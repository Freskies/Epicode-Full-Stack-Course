"use strict";

const API_KEY = "PsKqrEqz3g0tkehrl1feKGTRuuUCPkiuaYqpQ9ae4IkweYgHHREnw4cE";
const allImages = document.querySelectorAll(".card img");
const allSmalls = document.querySelectorAll("small");
const allTitles = document.querySelectorAll(".card-title");

const album = document.querySelector(".album");

const allButtonEdit = document.querySelectorAll(".btn-group button:last-Child");
allButtonEdit.forEach(button => {
	button.textContent = "Hide";
	button.addEventListener("click", () => {
		button.parentElement.parentElement.parentElement.parentElement.classList.add(
			"d-none",
		);
	});
});

function getJSON(url, errorMsg = "Something went wrong") {
	return fetch(url, {
		headers: {
			Authorization: API_KEY,
		},
	}).then(response => {
		if (!response.ok) throw new Error(`${errorMsg} (${response.status})`);
		return response.json();
	});
}

function loadImages(button) {
	const url = `https://api.pexels.com/v1/search?query=${button.dataset.animal}&per_page=${allImages.length}`;
	getJSON(url, "Cannot load images").then(({ photos }) => {
		console.log(photos);
		photos.forEach(({ id, src }, i) => {
			allImages[i].src = src.portrait;
			allImages[i].dataset.id = id;
			allTitles[i].dataset.id = id;
			allSmalls[i].textContent = id;
		});
	});
}

function search(button) {
	button.dataset.animal = button.previousElementSibling.value;
	button.previousElementSibling.value = "";
	loadImages(button);
}

document.querySelector("#form").addEventListener("submit", event => {
	event.preventDefault();
	search(event.target.lastElementChild);
});

// when i click on the images i want to see the detail
album.addEventListener("click", event => {
	if (event.target.tagName === "IMG" || event.target.tagName === "H5") {
		const id = event.target.dataset.id;
		window.location.href = `details.html?id=${id}`;
	}
});

loadImages({ dataset: { animal: "dog" } });
