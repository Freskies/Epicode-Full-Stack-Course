"use strict";

const valerio = {
	name: "Valerio",
	surname: "Giacchini",
	birthYear: 2003,

	calcAgeNo: () => 2024 - birthYear,

	calcAgeEx: birthYear => 2024 - birthYear,

	calcAge: function () {
		return 2024 - this.birthYear;
	},
};

console.log(valerio.calcAgeEx(valerio.birthYear));
console.log(valerio.calcAge());
// console.log(valerio.calcAge);
// console.log(valerio.calcAgeNo());

const arr = [1, 2, 3, 4];

const sumArr = arr => {
	if (!arr[0]) return 0;
	return arr[0] + sumArr([...arr.slice(1)]);
};

console.log(sumArr(arr));
const firstVariable = 5;
const secondVariable = 8;

const x =
	firstVariable === secondVariable
		? 7
		: firstVariable >= secondVariable
		? 5
		: 6;

const cacca =
	"ci godo le mie palle. ciao mi chiamo luis e mi fa male il dentino. io non pago affitto";
