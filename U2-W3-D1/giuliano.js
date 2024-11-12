"use strict";

/*
function Person(fisrtName, birthYear) {
	this.fisrtName = fisrtName;
	this.birthYear = birthYear;
}

Person.prototype.calcAge = function () {
	new Date().getFullYear() - this.birthYear;
};

Array.prototype.unique = function () {
	return [...new Set(this)];
};

const arr = [1, 2, 3, 1, 2, 3, 1, 2, 3];
console.log(arr.unique());

const valerio = new Person("Valerio", 2003);

// 1. new Object() = {}
// 2. set this to {}
// 3. link {} to __proto__
// 4. return the object

console.log(valerio.__proto__ === Person.prototype);
console.log(valerio instanceof Person);
console.log(valerio.calcAge());
*/

class Person {
	constructor(firstName, birthYear) {
		this.firstName = firstName;
		this.birthYear = birthYear;
	}

	get birthYear() {
		return this._birthYear;
	}

	set birthYear(birthYear) {
		if (birthYear < 0) throw new Error("Le mie palle sudate");
		this._birthYear = birthYear;
	}

	get age() {
		return new Date().getFullYear() - this.birthYear;
	}
}

class Male extends Person {
	constructor(firstName, birthYear) {}
	elicopter() {}
}

const valerio = new Person("Valerio", 2003);
console.log(valerio);

valerio.birthYear = 2003;
console.log(valerio.age);
