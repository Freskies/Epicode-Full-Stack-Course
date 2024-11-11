"use strict";

class Person {
	constructor(firstName, birthYear) {
		this.firstName = firstName;
		this.birthYear = birthYear;
	}

	calcAge() {
		return new Date().getFullYear() - this.birthYear;
	}
}

class Male extends Person {
	elicopter() {
		console.log("yes it's what you think");
	}
}

const valerio = new Male("Valerio", 2003);
console.log(valerio.calcAge());
valerio.elicopter();

class Student extends Person {
	constructor(firstName, birthYear, course) {
		super(firstName, birthYear);
		this.course = course;
	}

	introduce() {
		console.log(`My name is ${this.firstName} and I study ${this.course}`);
	}
}

const john = new Student("John", 2000, "Computer Science");
john.introduce();
