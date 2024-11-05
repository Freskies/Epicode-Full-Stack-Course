"use strict";

// this is a nice title => This Is a Nice Title
const convertTitleCaseL1 = title =>
	title
		.split(" ")
		.map(word =>
			word.length > 1
				? `${word[0].toUpperCase()}${word.slice(1).toLowerCase()}`
				: word.toLowerCase(),
		)
		.join(" ");

const convertTitleCase = title => {
	const exceptions = ["a", "an", "the", "but", "or", "on", "in", "with"];
	return title
		.toLowerCase()
		.split(" ")
		.map(word =>
			exceptions.includes(word)
				? word
				: `${word[0].toUpperCase()}${word.slice(1)}`,
		)
		.join(" ");
};

console.log(convertTitleCase("this is a nice title"));
