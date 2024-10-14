/* ESERCIZIO 1
  Scrivi una funzione per concatenare due stringhe ricevute come parametri, selezionando solamente i primi 2 caratteri della
  prima e gli ultimi 3 della seconda. Converti la stringa risultante in maiuscolo e mostrala con un console.log().
*/

const es1 = (s1, s2) => `${s1.substring(0, 2)}${s2.slice(-3)}`.toUpperCase();
// console.log(es1("ciao", "luis"));

/* ESERCIZIO 2 (for)
  Scrivi una funzione che torni un array di 10 elementi; ognuno di essi deve essere un valore random compreso tra 0 e 100 (incluso).
*/

const es2 = () => Array.from(Array(10), () => Math.floor(Math.random() * 101));
// console.log(es2());

/* ESERCIZIO 3 (filter)
  Scrivi una funzione per ricavare solamente i valori PARI da un array composto da soli valori numerici
*/
const casualNumbers = es2();
const es3 = numbers => numbers.filter(number => !(number % 2));
// console.log(es3(casualNumbers));

/* ESERCIZIO 4 (forEach)
  Scrivi una funzione per sommare i numeri contenuti in un array
*/

const es4 = numbers => {
	let sum = 0;
	numbers.forEach(number => (sum += number));
	return sum;
};

// console.log(es4([10, 10, 10]));

/* ESERCIZIO 5 (reduce)
  Scrivi una funzione per sommare i numeri contenuti in un array
*/

const es5 = numbers => numbers.reduce((sum, number) => (sum += number), 0);
// console.log(es5([10, 10, 10]));

/* ESERCIZIO 6 (map)
  Scrivi una funzione che, dato un array di soli numeri e un numero n come parametri, ritorni un secondo array con tutti i valori del precedente incrementati di n
*/
const es6 = (numbers, n) => numbers.map(number => (number += n));
// console.log(es6([10, 10, 10], 5));

/* ESERCIZIO 7 (map)
  Scrivi una funzione che, dato un array di stringhe, ritorni un nuovo array contenente le lunghezze delle rispettive stringhe dell'array di partenza
  es.: ["EPICODE", "is", "great"] => [7, 2, 5]
*/
const es7 = strings => strings.map(string => string.length);
// const strings = ["ciao", "mi", "chiamo", "luis"];
// console.log(es7(strings));
// console.log(strings);

/* ESERCIZIO 8 (forEach o for)
  Scrivi una funzione per creare un array contenente tutti i valori DISPARI da 1 a 99.
*/
const es8 = () => {
	const newArr = [];
	for (let i = 1; i <= 99; i += 2) newArr.push(i);
	return newArr;
};

// console.log(es8());

/* Questo array di film verrà usato negli esercizi a seguire. Non modificarlo e scorri oltre per riprendere gli esercizi :) */
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

/* ESERCIZIO 9 (forEach)
  Scrivi una funzione per trovare il film più vecchio nell'array fornito.
*/

const es9 = films => {
	let oldestfilm = films[0];
	films.forEach(
		film => (oldestfilm = oldestfilm.Year > film.Year ? film : oldestfilm),
	);
	return oldestfilm;
};
// console.log(es9(movies));

/* ESERCIZIO 10
  Scrivi una funzione per ottenere il numero di film contenuti nell'array fornito.
*/

const es10 = films => films.length;
// console.log(es10(movies));

/* ESERCIZIO 11 (map)
  Scrivi una funzione per creare un array con solamente i titoli dei film contenuti nell'array fornito.
*/

const es11 = films => films.map(film => film.Title);
// console.log(es11(movies));

/* ESERCIZIO 12 (filter)
  Scrivi una funzione per ottenere dall'array fornito solamente i film usciti nel millennio corrente.
*/
const es12 = films => films.filter(film => film.Year >= "2000");
// console.log(es12(movies));

/* ESERCIZIO 13 (reduce)
  Scrivi una funzione per calcolare la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array fornito.
*/

const es13 = films =>
	films.reduce((sum, film) => (sum += Number(film.Year)), 0);
// console.log(es13(movies));

/* ESERCIZIO 14 (find)
  Scrivi una funzione per ottenere dall'array fornito uno specifico film (la funzione riceve un imdbID come parametro).
*/

const es14 = (films, imdbID) => films.find(film => film.imdbID === imdbID);
// console.log(es14(movies, "tt0167261"));

/* ESERCIZIO 15 (findIndex)
  Scrivi una funzione per ottenere dall'array fornito l'indice del primo film uscito nell'anno fornito come parametro.
*/
const es15 = (films, year) => films.findIndex(film => film.Year === year);
// console.log(es15(movies, "2015"));
