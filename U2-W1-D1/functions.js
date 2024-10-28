"use strict";

/*
const bookings = [];

const createBooking = function (
	flightNum,
	numPassengers = 1,
	price = numPassengers * 199,
) {
	const booking = {
		flightNum,
		numPassengers,
		price,
	};
	bookings.push(booking);
};

createBooking("LH123", 3);
createBooking("LH124", undefined, 350);

console.log(bookings);
*/

/*

const oneWorld = function (str) {
	return str.replace(/ /g, "").toLowerCase();
};

const upperFirstWorld = function (str) {
	const [first, ...others] = str.split(" ");
	return [first.toUpperCase(), ...others].join(" ");
};

const transformer = function (str, fn) {
	console.log(`Original String: "${str}"`);
	console.log(`Transformed String: "${fn(str)}"`);

	console.log(`Transformed by: ${fn.name}`);
};

transformer("JavaScript is the best!", oneWorld);
transformer("JavaScript is the best!", upperFirstWorld);
 */

/*
const greet = function (greeting) {
	return function (name) {
		console.log(`${greeting} ${name}`);
	};
};

greet("Hello")("Valerio");

const greetArr = greeting => name => console.log(`${greeting} ${name}`);

greetArr("Hey")("Ray");
*/

const lufthansa = {
	airline: "Lufthansa",
	iataCode: "LH",
	bookings: [],

	book(flightNum, passengerName) {
		console.log(
			`${passengerName} booked a seat on ${this.airline} flight ${this.iataCode}${flightNum}`,
		);
		this.bookings.push({
			flight: `${this.iataCode}${flightNum}`,
			passengerName,
		});
	},
};

lufthansa.book(239, "Valerio");
lufthansa.book(635, "Anna");

const eurowings = {
	airline: "Eurowings",
	iataCode: "EW",
	bookings: [],
};

const book = lufthansa.book;

// book(23, "Sarah Williams");
book.call(eurowings, 23, "Sarah Williams");
book.apply(eurowings, [583, "Sara"]);

const bookEW = book.bind(eurowings);
bookEW(89, "Lara");

const bookEW23 = book.bind(eurowings, 23);
bookEW23("Alberto");
console.log(eurowings);

lufthansa.planes = 300;
lufthansa.buyPlane = function () {
	this.planes++;
	console.log(this.planes);
};
document
	.querySelector(".buy")
	.addEventListener("click", lufthansa.buyPlane.bind(lufthansa));

const addTax = (rate, value) => value + value * rate;
console.log(addTax(0.1, 200));

const addVAT = addTax.bind(null, 0.23);
console.log(addVAT(100));

const applyVAT = rate => value => addTax(rate, value);
console.log(applyVAT(0.27)(100));

(() => console.log("IIFE Immediately Invoked Function Expression"))();
