/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

function es1(a, b) {
	return a > b ? a : b;
}

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

function es2(n) {
	if (n !== 5) console.log("not equal");
}

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

function es3(n) {
	return !(n % 5) ? "divisibile per 5" : null;
}

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

function es4(a, b) {
	return a === 8 || b === 8 || a + b === 8 || a - b === 8 || b - a === 8;
}

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

function es5(totalShoppingCart) {
	return totalShoppingCart > 50 ? totalShoppingCart : totalShoppingCart + 10;
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

function es6(totalShoppingCart) {
	return es5(totalShoppingCart * 0.8);
}

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

function es7(a, b, c) {
	sortedArray = [];
	if (a > b && a > c) {
		sortedArray.push(a);
		if (b > c) sortedArray.push(b);
		else sortedArray.push(c);
	} else if (b > a && b > c) {
		sortedArray.push(b);
		if (a > c) sortedArray.push(a);
		else sortedArray.push(c);
	} else {
		sortedArray.push(c);
		if (a > b) sortedArray.push(a);
		else sortedArray.push(b);
	}
	return [...sortedArray];
}

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

function es8(n) {
	return typeof n === typeof 5;
}

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

function es9(n) {
	return !(n % 2) ? "even" : "odd";
}

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

function es10() {
	let val = 7;
	if (val < 10) {
		console.log("Meno di 10");
	} else if (val < 5) {
		console.log("Meno di 5");
	} else if (val >= 10) {
		console.log("Uguale a 10 o maggiore");
	}
}

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
	name: "John",
	lastName: "Doe",
	skills: ["javascript", "html", "css"],
};

me.city = "Toronto";

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

delete me.lastName;

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

me.skills.pop();

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

function e14() {
	const n = [];
	for (let i = 1; i <= 10; i++) n.push(i);
	return n;
}

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

const modifiedArr = e14();
modifiedArr[modifiedArr.length - 1] = 100;
