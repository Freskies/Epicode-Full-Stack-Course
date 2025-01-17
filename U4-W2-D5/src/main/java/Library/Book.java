package Library;

public class Book extends Publication {
	private String author;
	private String genre;

	// CONSTRUCTORS

	public Book (
		String isbn,
		String title,
		String publicationYear,
		int pageCount,
		String author,
		String genre
	) {
		super(isbn, title, publicationYear, pageCount);
		this.setAuthor(author);
		this.setGenre(genre);
	}

	// AUTHOR

	/**
	 * get the author of the book
	 *
	 * @return the author of the book
	 */
	public String getAuthor () {
		return this.author;
	}

	/**
	 * set the author of the book
	 * the author must not be blank and
	 * can contain only letters, spaces and dots
	 *
	 * @param author the author of the book
	 * @throws IllegalArgumentException if the author is invalid
	 */
	public void setAuthor (String author) {
		if (author.isBlank())
			throw new IllegalArgumentException("Author must not be blank");
		if (!author.matches("[a-zA-Z. ]+"))
			throw new IllegalArgumentException("Author must contain only letters, spaces and dots");
		this.author = author.trim();
	}

	// GENRE

	/**
	 * get the genre of the book
	 *
	 * @return the genre of the book
	 */
	public String getGenre () {
		return this.genre;
	}

	/**
	 * set the genre of the book
	 * the genre must not be blank and
	 * can contain only letters and spaces
	 *
	 * @param genre the genre of the book
	 * @throws IllegalArgumentException if the genre is invalid
	 */
	public void setGenre (String genre) {
		if (genre.isBlank())
			throw new IllegalArgumentException("Genre must not be blank");
		if (!genre.matches("[a-zA-Z ]+"))
			throw new IllegalArgumentException("Genre must contain only letters and spaces");
		this.genre = genre.trim();
	}

	// OVERRIDES

	@Override
	public String toString () {
		return "Book{" +
			"author='" + getAuthor() + '\'' +
			", genre='" + getGenre() + '\'' +
			", isbn='" + getIsbn() + '\'' +
			", title='" + getTitle() + '\'' +
			", publicationYear='" + getPublicationYear() + '\'' +
			", pageCount=" + getPageCount() +
			'}';
	}
}
