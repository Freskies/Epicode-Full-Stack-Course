"use strict";

const library = [];

/////////////////////////////////////
// GET BOOKS FROM THE SERVER

function getJSON(url, errorMessage = "Something went wrong") {
	return fetch(url).then(response => {
		if (!response.ok) throw new Error(`${errorMessage} ${response.status}`);
		return response.json();
	});
}

// get data from the server
getJSON("https://striveschool-api.herokuapp.com/books", "No books found")
	.then(books => {
		console.log(books);
		books.forEach(book => library.push(new Book(book)));
		library.forEach(book => book.render());
	})
	.catch(error => alert(error));

/////////////////////////////////////
// BUY BOOKS

document.querySelector(".library").addEventListener("click", event => {
	if (event.target.classList.contains("btn-buy")) {
		const book = library.find(book => book.equal(event.target.dataset.asin));
		console.log(book);
	}
});
