"use strict";

/* NUMBERS
console.log(23 === 23.0);
console.log(0.1 + 0.2);
console.log(0.1 + 0.2 === 0.3);

console.log(Number.parseInt("30px"));
console.log(Number.parseInt("30px", 2));

console.log(Number.parseInt("2.5rem"));
console.log(Number.parseFloat("2.5rem"));

console.log(Number.isNaN(20));
console.log(Number.isNaN("20"));
console.log(Number.isNaN(+"20r"));
console.log(Number.isNaN(23 / 0));

console.log(Number.isFinite(23 / 0));
console.log(Number.isNaN("20"));

console.log(Number.POSITIVE_INFINITY);
console.log(Number.NEGATIVE_INFINITY);
*/

/* MATH AND ROUNDING 
console.log(Math.sqrt(25));
console.log(25 ** (1 / 2));
console.log(8 ** (1 / 3));

console.log(Math.max(5, 18, -8, 4, "23"));

console.log(Math.PI);
console.log(Math.PI === 3.1415926535897932384626433832795028841971695093993751);

console.log(Math.ceil(Math.random() * 6)); // 1 - 6

// [min, max]
const randomInt = (min, max) =>
	Math.floor(Math.random() * (max - min + 1) + min);

// const poss = new Set(Array.from({ length: 100 }, _ => randomInt(-10, 5)));
// console.log([...poss].sort((a, b) => a - b));

console.log(+(2.7).toFixed(3));
*/

const diameter = 287_460_000_000;
console.log(diameter);
