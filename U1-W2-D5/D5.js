/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

"use strict";

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ["dog", "cat", "hamster", "redfish"];

const logArray = function (array) {
	for (let i = 0; i < array.length; i++) console.log(array[i]);
};

/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/

const isFirstElementAlphabeticFirst = function (array) {
	for (let i = 0; i < array.length; i++) if (array[0] > array[i]) return false;
	return true;
};

function sortedAlphabetically(array) {
	if (!array.length) return [];
	return isFirstElementAlphabeticFirst(array)
		? [array[0], ...sortedAlphabetically([...array.slice(1)])]
		: sortedAlphabetically([...array.slice(1), array[0]]);
}

/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/

const logReversedArray = function (array) {
	for (let i = array.length - 1; i >= 0; i--) console.log(array[i]);
};

/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/

const firstBecomeLast = array => [...array.slice(1), array[0]];

/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
	{
		brand: "Ford",
		model: "Fiesta",
		color: "red",
		trims: ["titanium", "st", "active"],
	},
	{
		brand: "Peugeot",
		model: "208",
		color: "blue",
		trims: ["allure", "GT"],
	},
	{
		brand: "Volkswagen",
		model: "Polo",
		color: "black",
		trims: ["life", "style", "r-line"],
	},
];

const getCasualLetter = function (alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ") {
	return alphabet[Math.floor(Math.random() * alphabet.length)];
};

const getCasualNumberChar = () => getCasualLetter("1234567890");

for (let i = 0; i < cars.length; i++)
	cars[i].licensePlate =
		getCasualLetter() +
		getCasualLetter() +
		getCasualNumberChar() +
		getCasualNumberChar() +
		getCasualNumberChar() +
		getCasualLetter() +
		getCasualLetter();

/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/

cars.push({
	brand: "Ferrari",
	model: "Fantastic Fast Ferrari",
	color: "red",
	trims: ["carbon", "spaghetti", "uranium"],
});

for (let i = 0; i < cars.length; i++) cars[i].trims.pop();

/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = [];

for (let i = 0; i < cars.length; i++) justTrims.push(cars[i].trims[0]);

/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/

const fizzOrBuzz = function (array) {
	for (let i = 0; i < array.length; i++)
		if (array[i].color[0] === "b") console.log("Fizz");
		else console.log("Buzz");
};

/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
	6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
];

const until32Included = function (numbers) {
	let i = 0;
	while (numbers[i]) {
		console.log(numbers[i]);
		if (numbers[i] === 32) break;
		i++;
	}
};

const until32Excluded = function (numbers) {
	let i = 0;
	while (numbers[i] && numbers[i] !== 32) {
		console.log(numbers[i]);
		i++;
	}
};

/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ["g", "n", "u", "z", "d"];
