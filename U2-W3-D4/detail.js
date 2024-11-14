"use strict";

const body = document.querySelector("body");
const artist = document.querySelector("#artist");
const img = document.querySelector("#image");

const API_KEY = "PsKqrEqz3g0tkehrl1feKGTRuuUCPkiuaYqpQ9ae4IkweYgHHREnw4cE";

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

function loadImage(id) {
	const url = `https://api.pexels.com/v1/photos/${id}`;
	getJSON(url, "Cannot load images").then(
		({ alt, avg_color: color, photographer, photographer_url: url, src }) => {
			body.style.backgroundColor = color;
			artist.textContent = `${photographer}`;
			artist.href = url;
			img.src = src.portrait;
			img.alt = alt;
		},
	);
}

// get id from url
const id = new URLSearchParams(window.location.search).get("id");
loadImage(id);
