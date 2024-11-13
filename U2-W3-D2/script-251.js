"use strict";

const cardsContainer = document.querySelector(".cards-container");

const renderCountry = (data, className = "") => {
	const card = `
			<article class="card ${className}">
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
};

const getCountryAndNeighbourData = function (country) {
	const request = new XMLHttpRequest();
	request.open("GET", `https://restcountries.com/v3.1/name/${country}`);
	request.send();

	request.addEventListener("load", function () {
		const [data] = JSON.parse(this.responseText);
		console.log(data);
		renderCountry(data);

		// gei nieghbour country
		const [neighbour] = data.borders;

		if (!neighbour) return;

		const request2 = new XMLHttpRequest();
		request2.open("GET", `https://restcountries.com/v3.1/alpha/${neighbour}`);
		request2.send();

		request2.addEventListener("load", function () {
			const [data2] = JSON.parse(this.responseText);
			renderCountry(data2, "neighbour");
		});
	});
};

getCountryAndNeighbourData("portugal");
