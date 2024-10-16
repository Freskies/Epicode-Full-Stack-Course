"use strict";

const restourant = {
	name: "Classico Italiano",
	location: "Via Della Viola 1, Casalborsetti, Italy",
	categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
	starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
	mainMenu: ["Pizza", "Pasta", "Risotto"],
	openingHours: {
		thu: {
			open: 12,
			close: 22,
		},
		fri: {
			open: 11,
			close: 23,
		},
		sat: {
			open: 0,
			close: 24,
		},
	},

	order: function (starterMenuIndex, mainMenuIndex) {
		return [this.starterMenu[starterMenuIndex], this.mainMenu[mainMenuIndex]];
	},

	orderDelivery: function ({
		starterIndex = 1,
		mainIndex = 0,
		time = "20:00",
		address = "...",
	}) {
		console.log(
			`Ordered receiverd! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`,
		);
	},

	orderPasta: function (ing1, ing2, ing3) {
		console.log(
			`Here's your delicious pasta with ${ing1}, ${ing2} and ${ing3}`,
		);
	},

	orderPizza: function (...ingridients) {
		console.log(`Here's your delicious pasta with ${ingridients.join(", ")}`);
	},
};

// destructuring array
const [a, b, c] = [2, 3, 4];
console.log(a, b, c);

let [first, , third] = restourant.categories;
console.log(first, third);

[first, third] = [third, first];
console.log(first, third);

const [starter, main] = restourant.order(2, 0);
console.log(starter, main);

// nested destructuring
const nested = [2, 4, [8, 16]];
const [n1, , n34] = nested;
console.log(n1, n34);
const [, n2, [, n4]] = nested;
console.log(n2, n4);

// default values
const [num1 = 1, num2 = 1, num3 = 1] = [8, 9];
console.log(num1, num2, num3);

// destructuring objects
const { name: restourantName, openingHours, categories } = restourant;
console.log(restourantName, categories, openingHours);

// default values
const { menu: restourantMenu = [] } = restourant;
console.log(restourantMenu);

// re-assing alrady declared variables
let [d, f] = [55, 66];
const obj = { d: 23, e: 85, f: 48 };
({ d, f } = obj);
console.log(d, f);

// nested objects
const {
	fri: { open: friOpen, close: friClose },
} = openingHours;
console.log(friOpen, friClose);

// passing object to destructure
restourant.orderDelivery({
	time: "22:30",
	// address: "Via G. Morgagni 49",
	mainIndex: 2,
	starterIndex: 2,
});

// the spread opertator
const arr = [4, 5, 6];
const newArr = [2, 3, ...arr];
console.log(newArr);
console.log(...newArr);

const newMenu = [...restourant.mainMenu, "Gnocchi"];
console.log(newMenu);

// Copy array
const mainMenuCopy = [...restourant.mainMenu];

// join arrays
const menu = [...restourant.starterMenu, ...restourant.mainMenu];
console.log(menu);

// the spread operator works in all iterables
// objects aren't iterables!!!
// arrays, strings, maps, sets are iterables
const str = "Valerio";
const letters = [...str];
console.log(...letters);

// const ingridients = [
// 	prompt(`let's make pasta! Ingridient 1`),
// 	prompt(`let's make pasta! Ingridient 2`),
// 	prompt(`let's make pasta! Ingridient 3`),
// ];
const ingridients = ["mushrooms", "grana", "pepper"];

restourant.orderPasta(...ingridients);

// objects
const newRestourant = {
	...restourant,
	founder: "Giuseppe Ricci",
	foundedIn: 1998,
};
console.log(newRestourant);

// shallow copy
const restourantCopy = { ...restourant };

// spread operator vs rest operator
const ar = [1, 2, ...[3, 4]];
const [fi, se, ...others] = ar;
console.log(fi, se, others);

const [focaccia, , garlicBread, , ...otherFood] = menu;
console.log(focaccia, garlicBread, ...otherFood);

const { sat, ...weekdays } = restourant.openingHours;
console.log(sat, weekdays);

// fucntions
const numbers = [15, 87, 44];
const add = (...addends) => addends.reduce((sum, addend) => (sum += addend), 0);
console.log(add(1, 1), add(1, 2, 3, 4), add(...numbers));

restourant.orderPizza("mushrooms", "onion", "spinach");

// short circuiting
// logic operators: can use any data type, can return any data type, short-circuiting
console.log(3 || "Valerio", "" || "Valerio", true || 0, undefined || null);

restourant.numGuest = 0;
const guest1 = restourant.numGuest ? restourant.numGuest : 10;
const guest2 = restourant.numGuest || 10;
console.log(guest1, guest2);

console.log(0 && "Jonas", 7 && "Valerio");

// practical example
if (restourant.orderPizza) restourant.orderPizza("mushrooms");
restourant.orderPizza && restourant.orderPizza("mushrooms");

// nullish coalescing operator
restourant.numGuest = 0;
const guest3 = restourant.numGuest || 10;
const guest4 = restourant.numGuest ?? 10; // nullish values: null, undefind
console.log(guest3, guest4);

const rest1 = {
	name: "Capri",
	numGuests: 20,
};
const rest2 = {
	name: "La Piazza",
	owner: "Giovanni Venturi",
};

// rest1.numGuests = rest1.numGuests || 10;
// rest2.numGuests = rest2.numGuests || 10;
// or assignment

rest1.numGuests ||= 0;
rest2.numGuests ||= 0;
console.log(rest1, rest2);

rest1.numGuests ??= 10;
rest2.numGuests ??= 10;
console.log(rest1, rest2);

rest1.owner &&= "anonymous";
rest2.owner &&= "anonymous";
console.log(rest1, rest2);
