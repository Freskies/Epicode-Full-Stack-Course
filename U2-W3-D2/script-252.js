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

const getCountryData = country => {
	fetch(`https://restcountries.com/v3.1/name/${country}`)
		.then(response => response.json())
		.then(([data]) => renderCountry(data[0]));
};

const getCountryAndNeighbourData = country => {
	fetch(`https://restcountries.com/v3.1/name/${country}`)
		.then(response => response.json())
		.then(([data]) => {
			renderCountry(data);
			const neighbour = data.borders[0];
			if (!neighbour) return;
			return fetch(`https://restcountries.com/v3.1/alpha/${neighbour}`);
		})
		.then(response => response.json())
		.then(([data]) => renderCountry(data, "neighbour"));
};

getCountryAndNeighbourData("portugal");
