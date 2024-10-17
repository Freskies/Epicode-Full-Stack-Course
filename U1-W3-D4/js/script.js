"use strict";

// const body = document.getElementById("body");

// for (let i = 0; i < 4; i++) {
// 	const h2 = body.appendChild(document.createElement("h2"));
// 	const values = Array.from({ length: 3 }, () =>
// 		String(Math.floor(Math.random() * 20) + 1).padStart(2, 0),
// 	);

// 	h2.textContent = values.join(" ");
// }

const weekdays = ["mon", "tue", "wed", "thu", "fri", "sat", "sun"];

const openingHours = {
	[weekdays[3]]: {
		open: 12,
		close: 22,
	},
	[weekdays[4]]: {
		open: 11,
		close: 23,
	},
	[weekdays[5]]: {
		open: 0,
		close: 24,
	},
};

const restourant = {
	name: "Classico Italiano",
	location: "Via Della Viola 1, Casalborsetti, Italy",
	categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
	starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
	mainMenu: ["Pizza", "Pasta", "Risotto"],
	openingHours, // enhanced object literals

	order(starterMenuIndex, mainMenuIndex) {
		return [this.starterMenu[starterMenuIndex], this.mainMenu[mainMenuIndex]];
	},

	orderDelivery({
		starterIndex = 1,
		mainIndex = 0,
		time = "20:00",
		address = "...",
	}) {
		console.log(
			`Ordered receiverd! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`,
		);
	},

	orderPasta(ing1, ing2, ing3) {
		console.log(
			`Here's your delicious pasta with ${ing1}, ${ing2} and ${ing3}`,
		);
	},

	orderPizza(...ingridients) {
		console.log(`Here's your delicious pasta with ${ingridients.join(", ")}`);
	},
};

const airline = "TAP Air Portugal";
const plane = "A320";

console.log(plane[2]);

console.log(airline.indexOf("r"), airline.lastIndexOf("r"));
console.log(airline.indexOf("Portugal"), airline.indexOf("portugal"));

console.log(airline.slice(0, airline.indexOf(" ")));
console.log(airline.slice(airline.lastIndexOf(" ") + 1));

console.log(airline.slice(-2));
console.log(airline.slice(1, -2));

// B, E are middle seats
const checkMiddleSeat = seat => {
	new Set("BE").has(seat.slice(-1));
};

console.log(
	checkMiddleSeat("11B"),
	checkMiddleSeat("23C"),
	checkMiddleSeat("3E"),
);

// fix capitalization in a names
const passenger = "vALErIO";
console.log(passenger[0].toUpperCase() + passenger.slice(1).toLowerCase());

// comparing email
const email = "hello@giacchini.io";
const loginEmail = "  HELLO@GIACCHINI.IO \n";
const normalizezEmail = loginEmail.toLowerCase().trim();
console.log(email === normalizezEmail);

// replacing
const priceGB = "288,97£";
const priceUS = priceGB.replace("£", "$").replace(",", ".");
console.log(priceUS);

console.log("a".repeat(5));

const announcement =
	"All passengers come to boarding door 23. Boarding door 23!";
console.log(announcement.replaceAll("door", "gate"));

console.log(announcement.replace(/door/g, "gate"));

const plane2 = "A320neo";
console.log(plane2.includes("A320"));
console.log(plane2.startsWith("A320"));
console.log(plane2.includes("A320"));

console.log(plane.startsWith("A320") && plane.endsWith("neo"));

const checkBaggage = baggage => !baggage.toLowerCase().includes("pistol");

console.log(checkBaggage("I have a laptop"));
console.log(checkBaggage("I have a PISTOL"));

// split

console.log(..."a+very+nice+string".split("+"));

const capitalize = s =>
	Array.from(
		s.toLowerCase().trim().split(" "),
		trimmed => trimmed[0].toUpperCase() + trimmed.slice(1),
	).join(" ");

console.log(capitalize("ciao Mi CHIamo LUIs"));

const maskCreditCard = number => number.slice(-4).padStart(number.length, "x");
console.log(maskCreditCard("1234486701487845").match(/.{4}/g).join("-"));
/*
//////////////////////////////////////////
//// maps 2

const question = new Map([
	["question", "what's the best programming language?"],
	[1, "C"],
	[2, "Java"],
	[3, "Javascript"],
	["correct", 3],
	[true, "correct!"],
	[false, "Try again!"],
]);

const hoursMap = new Map(Object.entries(openingHours));
console.log(hoursMap);

console.log(question.get("question"));
for (const [key, value] of question)
	if (typeof key === "number") console.log(`Answer ${key}: ${value}`);

const answer = Number(prompt("Your answer: "));
console.log(question.get(answer === question.get("correct")));

//////////////////////////////////////////
//// maps

const rest = new Map();
rest
	.set("name", "Classico Italiano")
	.set(1, "Firenze, Italy")
	.set(2, "Lisbon, Portugal")
	.set("open", 11)
	.set("close", 23)
	.set(true, "we're open")
	.set(false, "we're close");

console.log(rest.get("name"), rest.get(false));
const time = 21;
console.log(rest.get(rest.get("open") < time && time < rest.get("close")));

console.log(rest.has("name"));
rest.delete(2);

//////////////////////////////////////////
//// sets

const letters = new Set("Valerio");
console.log(letters);

const orderSet = new Set(["Pasta", "Pizza", "Pizza", "Risotto"]);
console.log(orderSet.size);
console.log(orderSet.has("Pizza"), orderSet.has("Bread"));
orderSet.add("Garlic Bread");
orderSet.delete("Pizza");
console.log(orderSet);
// orderSet.clear();

for (const order of orderSet) console.log(order);

// exaple
const staff = ["Waiter", "Chef", "Manager", "Chef", "Waiter", "Waiter"];
const positions = new Set(staff);
console.log(positions);

//////////////////////////////////////////
//// looping objects
for (const day of Object.keys(openingHours)) console.log(day);
for (const openHours of Object.values(openingHours)) console.log(openHours);
for (const [day, openHours] of Object.entries(openingHours))
	console.log(day, openHours);
for (const [day, { open, close }] of Object.entries(openingHours))
	console.log(`On ${day} we open at ${open} and close at ${close}`);

//////////////////////////////////////////
//// optional chaining

console.log(restourant.openingHours.mon?.open);

for (const day of weekdays)
	console.log(
		`${day}: open at ${
			restourant.openingHours?.[day]?.open ?? "/"
		} and close at ${restourant.openingHours[day]?.close ?? "/"}`,
	);

console.log(restourant.order?.(0, 1) ?? "Method doesn't exist");

//////////////////////////////////////////
//// for of

const menu = [...restourant.starterMenu, ...restourant.mainMenu];

for (const item of menu) console.log(item);

for (const [i, item] of menu.entries()) console.log(`${i + 1}. ${item}`);
*/
