"use strict";

// class expression
const Car = class {};

// class declaration
/**
 * Represents a person.
 * @class
 */
class Person {
	/**
	 * Creates an instance of a person.
	 * @constructor
	 * @param {string} fullName - The full name of the person.
	 * @param {number} birthYear - The birth year of the person.
	 */
	constructor(fullName, birthYear) {
		this.fullName = fullName;
		this.birthYear = birthYear;
	}

	// GETTER

	get fullName() {
		return this._fullName;
	}

	get birthYear() {
		return this._birthYear;
	}

	// SETTER

	set fullName(fullName) {
		// validation
		if (fullName.match(/[a-zA-Z] [a-zA-Z]/)) this._fullName = fullName;
		else console.log("error");
	}

	set birthYear(birthYear) {
		this._birthYear = birthYear;
	}

	// get a property that don't exist
	get age() {
		return 2037 - this.birthYear;
	}

	// Methods will be added to the prototype property of the class
	calcAge() {
		return 2037 - this.birthYear;
	}
}

Person.prototype.greet = function () {
	console.log(`My name id ${this.firstName}`);
};

const valerio = new Person("Valerio Giacchini", 2003);
console.log(valerio);
console.log(valerio.calcAge(), valerio.age);

valerio.fullName = "Valerio Violani";

// 1. Classes are NOT hoisted
// 2. Classes are first-class citizes
// 3. Classes are executed in strict mode

const account = {
	owner: "Valerio",
	movements: [123, 456, 789],

	get latest() {
		return this.movements.slice(-1).pop();
	},

	set latest(movement) {
		this.movements.push(movement);
	},

	get age() {
		return 2037 - this.birthYear;
	},
};

console.log(account.latest);
account.latest = 50;
console.log(account.latest);

const walter = new Person("Walter", 1997);

class Pulpet {}
