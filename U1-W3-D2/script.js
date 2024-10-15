"use strict";

/* ESERCIZIO 1
Scrivi una funzione per cambiare il titolo della pagina in qualcos'altro
*/

const changeTitle = function () {
	document.querySelector("h1").textContent = "Ciao mi chiamo Luis";
};

changeTitle();

/* ESERCIZIO 2
Scrivi una funzione per aggiungere al titolo della pagina una classe "myHeading"
*/

const addClassToTitle = function () {
	document.querySelector("h1").classList.add("myHeading");
};

addClassToTitle();

/* ESERCIZIO 3
Scrivi una funzione che cambi il testo dei p figli di un div
*/

const changePcontent = function () {
	document
		.querySelectorAll("div > p")
		.forEach(p => (p.textContent = "ci godo"));
};

changePcontent();

/* ESERCIZIO 4
Scrivi una funzione che cambi la proprietà href di ogni link (tranne quello nel footer) con il valore https://www.google.com
*/

const changeUrls = function () {
	document
		.querySelectorAll("a:not(footer a)")
		.forEach(a => (a.href = "https://www.google.com"));
};

changeUrls();

/* ESERCIZIO 5
Scrivi una funzione che aggiunga un nuovo elemento lista alla seconda lista non ordinata
*/

const addToTheSecond = function () {
	document
		.querySelector("#secondList")
		.appendChild(document.createElement("li"));
};

addToTheSecond();

/* ESERCIZIO 6
Scrivi una funzione che aggiunga un paragrafo al primo div
*/

const addParagraph = function () {
	document.querySelector("body div").appendChild(document.createElement("p"));
};

addParagraph();

/* ESERCIZIO 7
Scrivi una funzione che faccia scomparire la prima lista non ordinata
*/

const hideFirstUl = function () {
	document.querySelector("#firstList").style.display = "none";
};

hideFirstUl();

/* ESERCIZIO 8 
Scrivi una funzione che renda verde il background di ogni lista non ordinata
*/

const paintItGreen = function () {
	document
		.querySelectorAll("ul")
		.forEach(ul => (ul.style.backgroundColor = "green"));
};

paintItGreen();

/* ESERCIZIO 9
Scrivi una funzione che rimuova l'ultima lettera dall'h1 ogni volta che l'utente lo clicca
*/

const makeItClickable = function () {
	const h1 = document.querySelector("h1");
	h1.addEventListener("click", () => {
		h1.textContent = h1.textContent.substring(0, h1.textContent.length - 1);
	});
};

makeItClickable();

/* ESERCIZIO 10
Crea una funzione che, al click sul footer, riveli l'URL del link interno come contenuto di un alert()
*/

const revealFooterLink = function () {
	document.querySelector("footer").addEventListener("click", () => {
		alert(document.querySelector("footer a").href);
	});
};

revealFooterLink();

/* ESERCIZIO 11
Crea una funzione che crei una tabella nell'elemento con id "tableArea". 
La tabella avrà 5 elementi e questa struttura: immagine, nome prodotto, quantità, prezzo
*/

const generateTable = function () {
	const getRandomChar = s => s.charAt(Math.floor(Math.random() * s.length));

	const generateRandomName = () =>
		Array.from(
			Array(4),
			() => getRandomChar("bcdfghlmnpqrstvz") + getRandomChar("aeiou"),
		).join("");

	const tableContainer = document.querySelector("#tableArea");
	const tableElement = tableContainer.appendChild(
		document.createElement("table"),
	);

	const tableContent = Array.from(Array(5), () => {
		return {
			image: `https://picsum.photos/200/200?random=${Math.random()}`,
			name: generateRandomName(),
			quantity: Math.ceil(Math.random() * 9),
			price: Math.ceil(Math.random() * 99),
		};
	});

	tableContent.forEach(row => {
		const rowElement = tableElement.appendChild(document.createElement("tr"));
		const imgElement = rowElement
			.appendChild(document.createElement("td"))
			.appendChild(document.createElement("img"));
		imgElement.src = row.image;
		[row.name, row.quantity, row.price].forEach(data => {
			rowElement.appendChild(document.createElement("td")).textContent = data;
		});
	});
};

generateTable();

/* ESERCIZIO 12
Crea una funzione che aggiunga una riga alla tabella precedentemente creata e fornisca i dati necessari come parametri
*/

const addRow = function () {
	const rowElement = document
		.querySelector("table")
		.appendChild(document.createElement("tr"));
	const imgElement = rowElement
		.appendChild(document.createElement("td"))
		.appendChild(document.createElement("img"));

	const row = {
		image: `https://picsum.photos/200/200?random=${Math.random()}`,
		name: "ultimo",
		quantity: Math.ceil(Math.random() * 9),
		price: Math.ceil(Math.random() * 99),
	};

	imgElement.src = row.image;
	[row.name, row.quantity, row.price].forEach(data => {
		rowElement.appendChild(document.createElement("td")).textContent = data;
	});
};

addRow();

/* ESERCIZIO 14
Crea una funzione che nasconda le immagini della tabella quando eseguita
*/

const hideAllImages = function () {
	document.querySelectorAll("table img").forEach(image => {
		image.style.display = "none";
	});
};

hideAllImages();

/* EXTRA ESERCIZIO 15
Crea una funzione che cambi il colore del h2 con id "changeMyColor" con un colore random ad ogni click ricevuto
*/

const changeColorWithRandom = function () {
	const getRandomColor = () =>
		"#" +
		Array.from(Array(6), () =>
			"0123456789ABCDEF".charAt(Math.floor(Math.random() * 16)),
		).join("");

	const heading = document.querySelector("#changeMyColor");

	heading.addEventListener("click", () => {
		heading.style.color = getRandomColor();
	});
};

changeColorWithRandom();
