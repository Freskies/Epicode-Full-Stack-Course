function Book({ book: { asin, img, price, title }, setSelectedBook }) {
	return (
		<li className="book" onClick={_ => setSelectedBook(asin)}>
			<img className="book-cover" src={img} alt={title} />
			<p className="book-title">{title}</p>
			<p className="book-price">{price}</p>
		</li>
	);
}

export default Book;
