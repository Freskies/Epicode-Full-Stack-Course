// SLICE
let arr = ["a", "b", "c", "d", "e"];
const newArr = arr.slice(-2);
console.log(newArr);

// SPLICE (mutate)
arr.splice(-1);
console.log(arr);

// REVERSE (mutate)
console.log(arr.reverse());

// CONCAT
const arr2 = ["f", "g", "l"];
const letters = arr.concat(arr2);
console.log(letters);
console.log(arr);

const arr3 = [23, 11, 64];
console.log(arr3[arr3.length - 1]);
console.log(arr3.at(-1));

// classic for: have continue and break

const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

for (const movement of movements)
	if (movement > 0) console.log(`You deposited ${movement}`);
	else console.log(`You withdrew ${Math.abs(movement)}`);

console.log("----------------------------");

movements.forEach(movement => {
	if (movement > 0) console.log(`You deposited ${movement}`);
	else console.log(`You withdrew ${Math.abs(movement)}`);
});

console.log("----------------------------");

for (const [i, movement] of movements.entries())
	if (movement > 0) console.log(`${i}. You deposited ${movement}`);
	else console.log(`${i}. You withdrew ${Math.abs(movement)}`);

console.log("----------------------------");

movements.forEach((movement, i) => {
	if (movement > 0) console.log(`${i}. You deposited ${movement}`);
	else console.log(`${i}. You withdrew ${Math.abs(movement)}`);
});

// Map
const currencies = new Map([
	["USD", "United States dollar"],
	["EUR", "Euro"],
	["GBP", "Pound sterling"],
]);

currencies.forEach((value, key, map) => {
	console.log(`${key}: ${value}`);
});

// Set
const currenciesUnique = new Set(["USD", "GBP", "EUR"]);
currenciesUnique.forEach((value, _, set) => {
	console.log(`${value}: ${value}`);
});
