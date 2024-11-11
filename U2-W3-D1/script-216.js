"use strict";

/**
 * Represents a person with a first name and birth year.
 * @class
 */
class Person {
	/**
	 * Creates an instance of a person.
	 * @constructor
	 * @param {string} firstName - The first name of the person.
	 * @param {number} birthYear - The birth year of the person.
	 */
	constructor(firstName, birthYear) {
		this.firstName = firstName;
		this.birthYear = birthYear;
	}

	/**
	 * Gets the first name.
	 * @returns {string} The first name.
	 */
	get firstName() {
		return this._firstName;
	}

	/**
	 * Sets the first name.
	 * @param {string} value - The first name to set.
	 */
	set firstName(value) {
		this._firstName = value;
	}

	/**
	 * Gets the birth year.
	 * @returns {number} The birth year.
	 */
	get birthYear() {
		return this._birthYear;
	}

	/**
	 * Sets the birth year.
	 * @param {number} value - The year of birth to set.
	 */
	set birthYear(value) {
		this._birthYear = value;
	}

	/**
	 * Calculates the age based on the current year and the birth year.
	 * @returns {number} The calculated age.
	 */
	calcAge() {
		return new Date().getFullYear() - this.birthYear;
	}

	/**
	 * Logs "Hey there" to the console.
	 */
	static hey() {
		console.log("Hey there");
	}
}

const valerio = new Person("Valerio", 2003);
Person.hey();
valerio.hey();
