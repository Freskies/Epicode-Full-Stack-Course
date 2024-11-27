import Book from "./book";

function Books({ books, searchText }) {
	return (
		<div className="book-container">
			{books
				.filter(({ title }) =>
					title.toLowerCase().includes(searchText.toLowerCase().trim()),
				)
				.map(book => (
					<Book key={book.asin} book={book} />
				))}
		</div>
	);
}

export default Books;
