"use strict";

function Person(firstName, birthYear) {
	this.firstName = firstName;
	this.birthYear = birthYear;
}

Person.prototype.calcAge = function () {
	return 2037 - this.birthYear;
};

Person.prototype.species = "Homo Sapiens";

const valerio = new Person("Valerio", 2003);
const marco = new Person("Marco", 2003);

console.log(valerio.calcAge());
console.log(valerio.__proto__ === Person.prototype);
console.log(Person.prototype.isPrototypeOf(valerio));

console.log(valerio.species);
console.log(valerio.hasOwnProperty("firstName"));
console.log(valerio.hasOwnProperty("species"));

console.log("-------------------------");
console.log(valerio.__proto__); // Person Prototype
console.log(valerio.__proto__.__proto__); // Object Prototype
console.log(valerio.__proto__.__proto__.__proto__); // null (end proto chain)

Array.prototype.unique = function () {
	return [...new Set(this)];
};

const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 5, 4, 8, 7, 6, 2, 5, 4, 1, 2, 6];
console.log(arr);
console.log(arr.unique());
