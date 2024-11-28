import Book from "./Book";

function Books({ filteredBooks, setSelectedBook }) {
	return (
		<ul className="books">
			{filteredBooks.map(book => (
				<Book key={book.asin} book={book} setSelectedBook={setSelectedBook} />
			))}
		</ul>
	);
}

export default Books;
