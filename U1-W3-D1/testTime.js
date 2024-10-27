"use strict";

const questions = [];

for (let i = 0; i < 15; i++)
	questions.push({
		question: `cacca${i}`,
	});

console.time();

const getRandomElements = (array, items_left) => {
	if (items_left === 0) return [];
	const index = Math.floor(Math.random() * array.length);
	return [
		array[index],
		...getRandomElements(
			array.filter(el => el !== array[index]),
			items_left - 1,
		),
	];
};

const ri = getRandomElements(questions, 5);

console.timeEnd();

console.log(ri);
