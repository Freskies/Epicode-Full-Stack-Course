"use strict";

const PersonProto = {
	/**
	 * Initializes the object with the given first name and birth year.
	 *
	 * @param {string} firstName - The first name of the person.
	 * @param {number} birthYear - The birth year of the person.
	 */
	init(firstName, birthYear) {
		this.firstName = firstName;
		this.birthYear = birthYear;
	},

	/**
	 * Gets the first name.
	 * @returns {string} The first name.
	 */
	get firstName() {
		return this._firstName;
	},

	/**
	 * Sets the first name.
	 * @param {string} value - The first name to set.
	 */
	set firstName(value) {
		this._firstName = value;
	},

	/**
	 * Gets the birth year.
	 * @returns {number} The birth year.
	 */
	get birthYear() {
		return this._birthYear;
	},

	/**
	 * Sets the birth year.
	 * @param {number} value - The year of birth to set.
	 */
	set birthYear(value) {
		this._birthYear = value;
	},

	/**
	 * Calculates the age based on the current year and the birth year.
	 * @returns {number} The calculated age.
	 */
	calcAge() {
		return new Date().getFullYear() - this.birthYear;
	},
};

const valerio = Object.create(PersonProto);
console.log(valerio);
valerio.name = "Valerio";
valerio.birthYear = 2003;
console.log(valerio.calcAge());

const jonas = Object.create(PersonProto);
jonas.init("Jonas", 1991);
console.log(jonas.calcAge());
