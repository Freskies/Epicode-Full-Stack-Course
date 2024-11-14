"use strict";

const cardsContainer = document.querySelector(".cards-container");
const wai = document.querySelector(".wai");

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

const getJSON = (url, errorMessage = "Something went wrong") =>
	fetch(url).then(response => {
		if (!response.ok) throw new Error(`${errorMessage} ${response.status}`);
		return response.json();
	});

const getCountryAndNeighbourData = country => {
	getJSON(`https://restcountries.com/v3.1/name/${country}`, "Country not found")
		.then(([data]) => {
			renderCountry(data);
			const neighbour = data.borders?.[0];
			if (!neighbour) throw new Error("No neighbour found");
			return getJSON(
				`https://restcountries.com/v3.1/alpha/${neighbour}`,
				"Country not found",
			);
		})
		.then(([data]) => renderCountry(data, "neighbour"))
		.catch(error => alert(error));
};

wai.addEventListener("click", () => {
	getCountryAndNeighbourData("australia");
});
