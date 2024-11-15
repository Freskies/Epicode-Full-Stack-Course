"use strict";

const STRIVE_STUDENT_KEY =
	"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MDNhZThhZDEyOTAwMTU4NzZiYmUiLCJpYXQiOjE3MzE2NTg2NzAsImV4cCI6MTczMjg2ODI3MH0.0P0zNnw36mSTHpZpJ1FAAH2HiZsI_4PpWfZ5cs7bCDs";

function deleteProduct(id) {
	fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
		method: "DELETE",
		headers: {
			Authorization: STRIVE_STUDENT_KEY,
		},
	});
}

function createProduct(product) {
	fetch("https://striveschool-api.herokuapp.com/api/product/", {
		method: "POST",
		headers: {
			Authorization: STRIVE_STUDENT_KEY,
			"Content-Type": "application/json",
		},
		body: JSON.stringify(product),
	})
		.then(response => console.log(response))
		.catch(error => {
			alert("Something went wrong in pushing a product! Error: " + error);
		});
}

const nameInput = document.querySelector("#name");
const descriptionInput = document.querySelector("#description");
const brandInput = document.querySelector("#brand");
const priceInput = document.querySelector("#price");
const imageInput = document.querySelector("#imageUrl");
const form = document.querySelector("form");
const deleteButton = document.querySelector("#delete");
const addModifyButton = document.querySelector("#add-modify");
const confirmDialog = document.querySelector("#confirm-popup");
const dialogInfoWrapper = document.querySelector(".confirm-wrapper");

function closeDialog() {
	confirmDialog.close();
}

confirmDialog.addEventListener("click", e => {
	if (!dialogInfoWrapper.contains(e.target)) confirmDialog.close();
});

function showDialog(message, callback) {
	const messageField = document.querySelector("#confirm-popup .message");
	const confirmButton = document.querySelector("#confirm-popup .confirm");
	messageField.textContent = message;
	confirmButton.onclick = () => {
		confirmDialog.close();
		callback();
	};
	confirmDialog.showModal();
}

function sweep() {
	showDialog("Are you sure you want to clear the form?", clearForm);
}

function clearForm() {
	nameInput.value = "";
	descriptionInput.value = "";
	brandInput.value = "";
	priceInput.value = "";
	imageInput.value = "";
}

function getFormErrorMessage() {
	function validName() {
		if (nameInput.value.length < 5)
			return "Name must be at least 5 characters long";
	}
	function validDescription() {
		if (descriptionInput.value.length < 10)
			return "Description must be at least 10 characters long";
	}
	function validBrand() {
		if (brandInput.value.length < 3)
			return "Brand must be at least 3 characters long";
	}
	function validPrice() {
		if (isNaN(priceInput.value)) return "Price must be a number";
		if (priceInput.value <= 0) return "Price must be greater than 0";
	}
	function validImage() {
		if (!imageInput.value.startsWith("http"))
			return "Image must be a valid URL";
	}
	return (
		validName() ??
		validDescription() ??
		validBrand() ??
		validPrice() ??
		validImage()
	);
}

const id = new URLSearchParams(window.location.search).get("id");

if (id) {
	addModifyButton.textContent = "Modify";

	// fetch the product with the id
	fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
		headers: {
			Authorization: STRIVE_STUDENT_KEY,
		},
	})
		.then(response => response.json())
		.then(product => {
			nameInput.value = product.name;
			descriptionInput.value = product.description;
			brandInput.value = product.brand;
			priceInput.value = product.price;
			imageInput.value = product.imageUrl;
		})
		.catch(error => {
			alert("Product not found! Error: " + error);
		});
}

form.addEventListener("submit", e => {
	e.preventDefault();

	if (e.submitter.id === "delete") {
		if (id)
			showDialog("Are you sure you want to delete this product?", () => {
				deleteProduct(id);
				closeDialog();
				alert("Product deleted!");
				window.location.href = "back_office.html";
			});
	} else {
		// validate form
		const errorMessage = getFormErrorMessage();
		if (errorMessage) {
			alert(errorMessage);
			return;
		}

		if (id) {
			fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
				method: "PUT",
				headers: {
					Authorization: STRIVE_STUDENT_KEY,
					"Content-Type": "application/json",
				},
				body: JSON.stringify(
					new Card({
						name: nameInput.value,
						description: descriptionInput.value,
						brand: brandInput.value,
						price: priceInput.value,
						imageUrl: imageInput.value,
					}),
				),
			})
				.then(_ => {
					alert("Product modified!");
				})
				.catch(error => {
					alert("Something went wrong! Error: " + error);
					window.location.href = "back_office.html";
				});
		} else {
			createProduct(
				new Card({
					name: nameInput.value,
					description: descriptionInput.value,
					brand: brandInput.value,
					price: priceInput.value,
					imageUrl: imageInput.value,
				}),
			);
			alert("Product created!");
			clearForm();
		}
	}
});
