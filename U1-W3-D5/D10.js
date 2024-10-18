/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.
*/

const sum = 10 + 20;
// console.log(sum);

/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/

// 0 <= random <= 20
const random = Math.floor(Math.random() * 21);
// console.log(random);

/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/

const me = {
	name: "Valerio",
	surname: "Giacchini",
	age: 20,
};
// console.log(me);

/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/
delete me.age;
// console.log(me);

/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/
me.skills = ["Javascript", "Python", "C", "Java", "PHP", "Typescript"];
// console.log(me);

/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/

// const addSkill = (person, skill) => person.skills.push(skill);
// addSkill(me, "Z80");

me.skills.push("Z80");

// console.log(me);

/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/

me.skills.pop();
// console.log(me);

// Funzioni

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/

const dice = () => Math.ceil(Math.random() * 6);
// console.log(dice());

/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/

const whoIsBigger = (n1, n2) => (n1 > n2 ? n1 : n2);
// console.log(whoIsBigger());

/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.

  Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/

// I will overlook the fact that the array in the example is capitalized.
const splitMe = s => s.split(" ");

// console.log(splitMe("I love coding"));

/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/

const deleteOne = (s, cutFirst) => (cutFirst ? s.slice(1) : s.slice(0, -1));
// console.log(deleteOne("1234", true), deleteOne("1234", false));

/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/

// i used one regex to delete every char that is not "a-z", 'A-Z', ' '
// the second regex is to trim multiple spaces like in the exaple
const onlyLettersOld = s => s.replace(/[^a-zA-Z ]/g, "").replace(/  +/g, " ");
// console.log(onlyLettersOld("I have 4 dogs"));

// actually i just read that i have to cut off only numbers:
const onlyLetters = s => s.replace(/[0-9]/g, "").replace(/  +/g, " ");
// console.log(onlyLetters("I have 4 dogs"));

/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/

// this regex is copied from https://regexr.com/3e48o, i'm not able to write it myself but check an email with regex is so common that i think is fine
const isThisAnEmail = email =>
	email.match(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g) !== null;

// btw 'cause i'm not able to write it by myself i will do also a larger function on my own
const isThisAnEmailByMyself = email => {
	// check if it has only one @
	if (email.match(/@/g)?.length !== 1) return false;
	const [emailBody, emailFooter] = email.split("@");

	// check email body
	// if there is a char that is not a word (alphabetic + numbers + '_') or '.'
	// the match will return an array (truthy value), otherwise it'll return null (falsy)
	// I'll use that same conecpt again, so i'll never explain it again
	if (emailBody.match(/[^\w\.]/g)) return false;
	// if last char of body is '.' is invalid
	if (emailBody[emailBody.length - 1].match(/[^\w]/)) return false;

	// check email footer
	// if there aren't any '.' is invalid
	if (!emailFooter.match(/\./g)) return false;
	// split at last '.'
	const latsDotIndex = emailFooter.lastIndexOf(".");
	const [domain, domainRoot] = [
		emailFooter.slice(0, latsDotIndex),
		emailFooter.slice(latsDotIndex + 1),
	];
	// if first or last char of domain are special char is invalid
	if (domain[0].match(/[^\w]/) || domain[domain.length - 1].match(/[^\w]/))
		return false;
	// if there are multiple '.' concatenate is invalid
	if (domain.match(/\.\.+/g)) return false;
	// the root is between 2 to 4 char and are only letters
	if (!(2 <= domainRoot.length && domainRoot.length <= 4)) return false;
	if (domainRoot.match(/[^a-z]/)) return false;

	return true;
};

// i'm not normalizing the string before check it
// console.log(isThisAnEmailByMyself("freskies.bico.apo@gma.il.it"));

/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/

const weekdays = ["sun", "mon", "tue", "wed", "thu", "fri", "sat"];
const whatDayIsIt = (now = new Date()) => weekdays[now.getDay()];

// console.log(whatDayIsIt());
// console.log(whatDayIsIt(new Date("2024-10-19")));

/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/

const rollTheDices = dices => {
	const values = Array.from({ length: dices }, () => dice());
	return {
		values,
		sum: values.reduce((acc, value) => (acc += value), 0),
	};
};

// console.log(rollTheDices(5));

/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/

const howManyDays = date =>
	Math.abs(
		Math.round((new Date().getTime() - date.getTime()) / (1000 * 60 * 60 * 24)),
	);
// console.log(howManyDays(new Date("2024-10-23")));

/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/

const isTodayMyBirthday = (
	myBirth = new Date("2003-10-20"),
	now = new Date(),
) =>
	now.getDate() === myBirth.getDate() && now.getMonth() === myBirth.getMonth();

// console.log(isTodayMyBirthday(), isTodayMyBirthday(new Date()));

// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

// IMPORTANT
// i'll move up beacuse i didn't like to have all function call in the bottom

/* Questo array viene usato per gli esercizi. Non modificarlo. */

const movies = [
	{
		Title: "The Lord of the Rings: The Fellowship of the Ring",
		Year: "2001",
		imdbID: "tt0120737",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg",
	},

	{
		Title: "The Lord of the Rings: The Return of the King",
		Year: "2003",
		imdbID: "tt0167260",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
	},
	{
		Title: "The Lord of the Rings: The Two Towers",
		Year: "2002",
		imdbID: "tt0167261",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
	},
	{
		Title: "Lord of War",
		Year: "2005",
		imdbID: "tt0399295",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg",
	},
	{
		Title: "Lords of Dogtown",
		Year: "2005",
		imdbID: "tt0355702",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg",
	},
	{
		Title: "The Lord of the Rings",
		Year: "1978",
		imdbID: "tt0077869",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg",
	},
	{
		Title: "Lord of the Flies",
		Year: "1990",
		imdbID: "tt0100054",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg",
	},
	{
		Title: "The Lords of Salem",
		Year: "2012",
		imdbID: "tt1731697",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg",
	},
	{
		Title: "Greystoke: The Legend of Tarzan, Lord of the Apes",
		Year: "1984",
		imdbID: "tt0087365",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg",
	},
	{
		Title: "Lord of the Flies",
		Year: "1963",
		imdbID: "tt0057261",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg",
	},
	{
		Title: "The Avengers",
		Year: "2012",
		imdbID: "tt0848228",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
	},
	{
		Title: "Avengers: Infinity War",
		Year: "2018",
		imdbID: "tt4154756",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg",
	},
	{
		Title: "Avengers: Age of Ultron",
		Year: "2015",
		imdbID: "tt2395427",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg",
	},
	{
		Title: "Avengers: Endgame",
		Year: "2019",
		imdbID: "tt4154796",
		Type: "movie",
		Poster:
			"https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg",
	},
];

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/

const deleteProp = (obj, property) => {
	newObj = { ...obj };
	delete newObj[property];
	return newObj;
};

// const valerio = { surname: "Giacchini", age: 20 };
// console.log(deleteProp(valerio, "age1"), deleteProp(valerio, "age"));

/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/

const newestMovie = movies =>
	movies.reduce(
		(acc, movie) => (acc = acc.Year > movie.Year ? acc : movie),
		movies[0],
	);
// console.log(newestMovie(movies));

/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/

const countMovies = movies => movies.length;
// console.log(countMovies(movies));

/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/

const onlyTheYears = movies => Array.from(movies, movie => movie.Year);
// console.log(onlyTheYears(movies));

/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/
const onlyInLastMillennium = movies =>
	movies.filter(movie => movie.Year < "2000");
// console.log(onlyInLastMillennium(movies));

/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/
const sumAllTheYears = movies =>
	movies.reduce((acc, movie) => (acc += Number(movie.Year)), 0);
// console.log(sumAllTheYears(movies));

/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/
const searchByTitle = (movies, s) =>
	movies.filter(movie => movie.Title.includes(s));
// console.log(searchByTitle(movies, "Lords"));

/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/

// Venn algebra
const searchAndDivide = (movies, s) => {
	const allMovies = new Set(movies);
	const matches = new Set(searchByTitle(movies, s));
	return {
		match: [...matches],
		unmatch: [...allMovies.difference(matches)],
	};
};

// console.log(searchAndDivide(movies, "Lord"));

/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/

// I'm tired, I don't remember how the splice method works and I don't feel like to search for it, this time it's fine too xD
const removeIndex = (movies, index) => movies.filter((_, i) => i !== index);
// console.log(removeIndex(movies, 1));

// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/

const container = document.getElementById("container");

/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/
// i assume that the TDs are inside a tr
const getTableDataElements = () => document.querySelectorAll("td");

/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/

const logTableData = () =>
	getTableDataElements().forEach(td => console.log(td.textContent));

/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/
const redLinks = () =>
	document
		.querySelectorAll("a:link, a:hover, a:active, a:visited")
		.forEach(a => (a.style.backgroundColor = "red"));

/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/

const addToMyList = node => document.getElementById("myList").appendChild(node);

/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/

const clearMyList = () => (document.getElementById("myList").innerHTML = "");

/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/

const tableRowTest = () =>
	document.querySelectorAll("tr").forEach(tr => tr.classList.add("test"));

// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/

const halfTree = len => {
	if (!len) return "";
	return `${halfTree(len - 1)}\n${"*".repeat(len)}`;
};

// console.log(halfTree(6));

const halfTreeIterativeLog = len => {
	for (let i = 1; i <= len; i++) console.log(`*`.repeat(i));
};

// halfTreeIterativeLog(3);

/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/

// in this function you have to insert 5 to get the expected result for 3
const treeOld = (len, pad = 0) => {
	if (len < 1) return "";
	return `${tree(len - 2, pad + 1)}
  ${" ".repeat(pad)}${"*".repeat(len)}${" ".repeat(pad)}`;
};
// console.log(treeOld(16), "\n\n", treeOld(15));

const tree = (len, pad = 0) => {
	if (len < 1) return "";
	return `${tree(len - 1, pad + 1)}
  ${" ".repeat(pad)}${"*".repeat(len * 2 - 1)}${" ".repeat(pad)}`;
};

// console.log(tree(3), "\n\n", tree(5));

const treeIterativeLog = len => {
	for (let i = 1; i <= len; i++)
		console.log(`${" ".repeat(len - i)}${"*".repeat(i * 2 - 1)}`);
};

// treeIterative(3);

/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/
const isItPrime = (n, divisor = 2) => {
	if (n <= 1) return false; // 0, 1 are not prime
	if (divisor > n / 2) return true;
	return Boolean(n % divisor) && isItPrime(n, divisor + 1);
};

const isItPrimeIterative = n => {
	if (n <= 1) return false;
	for (let i = 2; i <= n / 2; i++) if (!(n % i)) return false;
	return true;
};

// const test100 = Array.from({ length: 100 }, (_, i) => ({
// 	number: i,
// 	isPrime: isItPrime(i),
// }));

// const prime100 = test100.filter(test => test.isPrime);

// prime100.forEach(prime => console.log(prime.number));
