"use strict";

const STRIVE_STUDENT_KEY =
	"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MDNhZThhZDEyOTAwMTU4NzZiYmUiLCJpYXQiOjE3MzE2NTg2NzAsImV4cCI6MTczMjg2ODI3MH0.0P0zNnw36mSTHpZpJ1FAAH2HiZsI_4PpWfZ5cs7bCDs";

const productsContainer = document.querySelector(".products-container");
const popup = document.getElementById("pop-up");
const popupContent = document.querySelector(".info-wrapper");
const loadingIndicator = document.getElementById("loading-indicator");

const cards = [];

popup.addEventListener("click", e => {
	if (!popupContent.contains(e.target)) popup.close();
});

function startLoading() {
	loadingIndicator.style.display = "block";
	loadingIndicator.textContent = "Loading";

	let dots = 0;
	const interval = setInterval(() => {
		if (dots === 3) {
			loadingIndicator.textContent = "Loading";
			dots = 0;
		} else {
			loadingIndicator.textContent += ".";
			dots++;
		}
	}, 1000);

	return () => {
		clearInterval(interval);
		loadingIndicator.style.display = "none";
	};
}

const stopLoading = startLoading();

fetch("https://striveschool-api.herokuapp.com/api/product/", {
	headers: {
		Authorization: STRIVE_STUDENT_KEY,
	},
})
	.then(response => response.json())
	.then(cardList => {
		stopLoading();
		cardList.forEach(card => cards.push(new Card(card).renderCard()));
	})
	.catch(error => {
		console.error("Error fetching products:", error);
	})
	.finally(() => {
		stopLoading();
	});

productsContainer.addEventListener("click", e => {
	const id = e.target.dataset.id;
	if (id)
		if (e.target.dataset.modify)
			window.location.href = `back_office.html?id=${id}`;
		else {
			// fill modal with card info
			console.log(cards);
			const card = cards.find(card => card.equals(id));
			const nameField = document.querySelector("#pop-up .name");
			const descriptionField = document.querySelector("#pop-up .description");
			const brandField = document.querySelector("#pop-up .brand");
			const priceField = document.querySelector("#pop-up .price");
			const imageField = document.querySelector("#pop-up .product-image");
			nameField.textContent = card.name;
			descriptionField.textContent = card.description;
			brandField.textContent = "—" + card.brand;
			priceField.textContent = "$" + card.price;
			imageField.src = card.imageUrl;
			imageField.alt = card.name;
			popup.showModal();
		}
});
