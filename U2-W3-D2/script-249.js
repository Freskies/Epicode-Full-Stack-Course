"use strict";

const cardsContainer = document.querySelector(".cards-container");

const getCountryData = function (country) {
	const request = new XMLHttpRequest();
	request.open("GET", `https://restcountries.com/v3.1/name/${country}`);
	request.send();

	request.addEventListener("load", function () {
		const [data] = JSON.parse(this.responseText);
		console.log(data);

		const card = `
			<article class="card">
				<img
					class="country-image"
					src="${data.flags.png}"
					alt="${data.flags.alt}"
				/>
				<div class="country-data">
					<h3 class="country-name">${data.name.common}</h3>
					<h4 class="country-region">${data.region}</h4>
					<p class="country-row">
						<span>👨‍👩‍👧‍👦</span>
						${(+data.population / 1_000_000).toFixed(1)} million people
					</p>
					<p class="country-row">
						<span>🗣️</span>
						${[...Object.values(data.languages)][0]}
					</p>
					<p class="country-row">
						<span>💰</span>
						${data.currencies[Object.keys(data.currencies)[0]].name}
					</p>
				</div>
			</article>
		`;

		cardsContainer.insertAdjacentHTML("beforeend", card);
	});
};

getCountryData("portugal");
getCountryData("usa");
getCountryData("italy");
