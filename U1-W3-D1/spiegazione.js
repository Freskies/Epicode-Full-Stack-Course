"use strict";

const arr = [1, 2, 3, 4];

const forEachFasullo = (array, funz) => {
	for (let i = 0; i < array.length; i++) funz(array[i]);
};

const f = elemento => {
	console.log(elemento);
};

forEachFasullo(arr, f);

forEachFasullo(arr, elemento => console.log(elemento));
