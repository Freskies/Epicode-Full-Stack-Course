// Esercizi aggiuntivi (facoltativi) per D4

/* EXTRA 1
 Scrivi una funzione chiamata "checkArray" che riceve un array di numeri casuali (creati con la funzione "giveMeRandom") e per ogni elemento stampa in console
 se il suo valore è maggiore di 5 o no.
 La funzione deve inoltre ritornare la somma di tutti i valori maggiori di 5.
*/

const checkArray = function (casualNumbers) {
	let sumGreaterThan5 = 0;
	for (let i = 0; i < casualNumbers.length; i++) {
		const greaterThan5 = casualNumbers[i] > 5;
		console.log(`il valore${greaterThan5 ? "" : " non"} è maggiore di 5`);
		if (greaterThan5) sumGreaterThan5 += casualNumbers[i];
	}
	return sumGreaterThan5;
};

/* EXTRA 2
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "shoppingCartTotal" che calcola il totale dovuto al negozio (tenendo conto delle quantità di ogni oggetto).
*/

const shoppingCart = [
	{
		price: 200,
		name: "monitor",
		id: 1,
		quantity: 3,
	},
	{
		price: 80,
		name: "case",
		id: 2,
		quantity: 1,
	},
	{
		price: 20,
		name: "keyboard",
		id: 3,
		quantity: 1,
	},
];

const shoppingCartTotal = function (shoppingCart) {
	let cartTotal = 0;
	for (let i = 0; i < shoppingCart.length; i++)
		cartTotal += shoppingCart[i].price * shoppingCart[i].quantity;
	return cartTotal;
};

/* EXTRA 3
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "addToShoppingCart" che riceve un nuovo oggetto dello stesso tipo, lo aggiunge a "shoppingCart" e ritorna il nuovo numero totale degli elementi.
*/

const addToShoppingCart = product => shoppingCart.push(product);

/* EXTRA 4
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "maxShoppingCart" che riceve l'array "shoppingCart" e ritorna l'oggetto più costoso in esso contenuto.
*/

const maxShoppingCart = function (shoppingCart) {
	mostValuableProduct = shoppingCart[0];
	for (let i = 0; i < shoppingCart.length; i++)
		if (mostValuableProduct.price < shoppingCart[i].price)
			mostValuableProduct = shoppingCart[i];
	return mostValuableProduct;
};

/* EXTRA 5
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "latestShoppingCart" che riceve l'array "shoppingCart" e ritorna l'ultimo elemento.
*/

const latestShoppingCart = shoppingCart =>
	shoppingCart[shoppingCart.length - 1];

/* EXTRA 6
 Crea una funzione chiamata "loopUntil" che riceve un numero intero come parametro con valore tra 0 e 9.
 La funzione è composta da un ciclo che stampa un numero casuale tra 0 e 9 finchè il numero casuale non è maggiore di x per tre volte di fila.
*/

const loopUntil = function (x) {
	let counterGreatherThen = 0;
	while (counterGreatherThen != 3) {
		let casual_number_bet_0_9 = Math.floor(Math.random() * 10);
		console.log(casual_number_bet_0_9);
		if (casual_number_bet_0_9 > x) counterGreatherThen++;
		else counterGreatherThen = 0;
	}
};

/* EXTRA 7
Crea una funzione chiamata "average" che riceve un array come parametro e ne ritorna la media aritmetica. La funzione salta automaticamente i valori non numerici nell'array.
*/

const average = function (values) {
	let sum = 0;
	let invalidValues = 0;

	for (let i = 0; i < values.length; i++)
		if (typeof values[i] === typeof 0) sum += values[i];
		else invalidValues++;

	return sum / (values.length - invalidValues);
};

/* EXTRA 8
 Crea una funzione chiamata "longest" che trova la stringa più lunga all'interno di un array di stringhe fornito come parametro.
*/

const longest = function (strings) {
	let longest = "";
	for (let i = 0; i < strings.length; i++)
		if (strings[i].length > longest.length) longest = strings[i];
	return longest;
};

/* EXTRA 9
 Crea una funzione per creare un filtro anti-spam per la tua casella email. La funzione riceve un parametro stringa chiamato "emailContent", e torna un valore booleano.
 La funzione deve ritornare true se "emailContent" non contiene le parole "SPAM" o "SCAM".
*/

const filterMail = emailContent =>
	!(emailContent.includes("SPAM") || emailContent.includes("SCAM"));

/* EXTRA 10
 Scrivi una funzione che riceve una data come parametro, e calcola il numero di giorni passati da quella data.
*/

const daysPassedBy = date =>
	Math.floor((new Date("2024-10-10") - date) / (1000 * 60 * 60 * 24));

// console.log(daysPassedBy(new Date("2024-10-09")));

/* EXTRA 11
 Scrivi una funzione chiamata "matrixGenerator" che riceve come parametri due numeri interi, "x" e "y".
 Il risultato deve essere una matrice di "x" volte "y", e i valori devono rispecchiare gli indici della posizione all'interno della matrice.
 Es.: x = 3, y = 2
 ["00","01","02"
 "10","11","12"]
*/

const matrixGenerator = function (x, y) {
	const matrix = [];
	for (let i = 0; i < y; i++) {
		const row = [];
		for (let j = 0; j < x; j++) row.push(`${i}${j}`);
		matrix.push(row);
	}
	return matrix;
};
