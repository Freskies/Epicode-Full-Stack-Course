"use strict";

// STRINGS

// template literals (i've succesfully binded altgr + rshift + ' = `)
const tl = `hello my name is ${"Valerio"} and i'm using template literals!`;

const multiLineString = `this
is
a 
multiline
string`;

// FUNCTIONS

// funtion declaration
function calcAge1(birthYear) {
	return 2024 - birthYear;
}

// function expression
const calcAge2 = function (birthYear) {
	return 2024 - birthYear;
};

// arrow function
const calcAge3 = birthYear => 2024 - birthYear;
