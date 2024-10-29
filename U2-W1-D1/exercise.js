"use strict";

// PART 1

const country = "Italy";
const continent = "Europe";
let population = 10;

const isIsland = false;

for (const info of [country, continent, population, isIsland])
	console.log(typeof info);

const language = "Italian";

const half = population / 2;
population++;
console.log(population);

const moreThanFinland = 6 > population;
const lessThanAvarage = 33 > population;

const description = `${country} is in ${continent}, and its ${population} million people speak ${language}`;
console.log(description);

/*
console.log('9' - '5'); -> 4
console.log('19' - '13' + '17'); -> '617'
console.log('19' - '13' + 17); -> 23
console.log('123' < 57); -> false
console.log(5 + 6 + '4' + 9 - 4 - 2); -> 1143
*/

if (population < 50 && language === "english" && !isIsland) console.log("yes");
else console.log("no");

switch (language.toLowerCase()) {
	case "chinese":
	case "mandarin":
		console.log("MOST number of native speakers!");
		break;
	case "spanish":
		console.log("2nd place in number of native speakers");
		break;
	case "english":
		console.log("3rd place");
		break;
	case "hindi":
		console.log("Number 4");
		break;
	case "arabic":
		console.log("5th most spoken language");
		break;
	default:
		console.log("Great language too :D");
}

console.log(
	`Portugal's population is ${population > 33 ? "above" : "below"} average`,
);

console.log("----------------------------------------");

// FUNCTIONS

function describeCountry(country, population, capitalCity) {
	return `${country} has ${population} million people and its capital city is ${capitalCity}`;
}

console.log(describeCountry("Finland", 6, "Helsinki"));

// 7900 : 100 = p : x => 100 * p / 7900
function percentageOfWorld1(population) {
	return (population * 100) / 7900;
}

const percentageOfWorld2 = function (population) {
	return (population * 100) / 7900;
};

const percentageOfWorld3 = population => (population * 100) / 7900;

console.log(percentageOfWorld1(1441));

const describePopulation = (country, population) =>
	`${country} has ${population} million people, which is about ${percentageOfWorld3(
		population,
	).toFixed(1)}% of the world`;

console.log(describePopulation("China", 1441));

const populations = [1140, 30, 6, 50];
console.log(populations.length === 4);

const percentages = populations.map(population =>
	percentageOfWorld3(population),
);

const neighbours = ["Norway", "Sweden", "Russia"];
neighbours.push("Utopia");
neighbours.pop();

if (neighbours.indexOf("Germany") === -1) console.log("ci godo");

neighbours[neighbours.indexOf("Sweden")] = "Republic of Sweeden";

const myCountry = {
	country: "Italy",
	capital: "Rome",
	language: "Italian",
	population: 10,
	neighbours: ["Austria", "San Marino"],
	pappa: 5,

	describe() {
		return `${this.country} has ${this.population} million ${this.language}-speaking people, ${this.neighbours.length} neighbouring countries and a capital called ${this.capital}`;
	},
};

myCountry.population += 2;
myCountry["population"] -= 2;

console.log(myCountry.describe());

// JAVASCRIPT FUNCTIONS PART 2 - OBJECT METHODS
