"use strict";

function Person(firstName, birthYear) {
	// instance properties
	this.firstName = firstName;
	this.birthYear = birthYear;

	// Never do this!!!
	this.calcAge = function () {
		console.log(2037 - this.birthYear);
	};
	// every instance will carry all functions that you declare here
}

const valerio = new Person("Valerio", 2003);
const marco = new Person("Marco", 2003);

console.log(valerio);
console.log(valerio instanceof Person);

// 1. new {} is created
// 2. this = {}
// 3. {} linked to prototype
// 4. funciton automatically return the object
