function Book({ book: { asin, title, img, price } }) {
	return (
		<figure className="book" data-asin={asin}>
			<img src={img} alt={title} data-src={img} />
			<figcaption>
				<h3 className="title" data-title={title}>
					{title}
				</h3>
				<p className="price">{price}</p>
			</figcaption>
		</figure>
	);
}

export default Book;
