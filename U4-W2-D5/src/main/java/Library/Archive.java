package Library;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Archive {
	private final Set<Publication> publications;

	public Archive () {
		super();
		this.publications = new HashSet<>();
	}

	// ADD

	/**
	 * Add a publication to the archive
	 *
	 * @param publication Publication to add
	 * @return True if the publication was added, false otherwise
	 */
	public boolean addPublication (Publication publication) {
		return this.publications.add(publication);
	}

	// GET

	/**
	 * Get all publications in the archive
	 *
	 * @return Set of all publications in the archive
	 */
	public Set<Publication> getAllPublication () {
		return this.publications;
	}

	/**
	 * Get all books in the archive
	 *
	 * @return Set of all books in the archive
	 */
	public Set<Book> getAllBooks () {
		return this.publications.stream()
			.filter(publication -> publication instanceof Book)
			.map(publication -> (Book) publication)
			.collect(Collectors.toSet());
	}

	/**
	 * Get all magazines in the archive
	 *
	 * @return Set of all magazines in the archive
	 */
	public Set<Magazine> getAllMagazine () {
		return this.publications.stream()
			.filter(publication -> publication instanceof Magazine)
			.map(publication -> (Magazine) publication)
			.collect(Collectors.toSet());
	}

	/**
	 * Get a publication by its ISBN
	 *
	 * @return Publication with the provided ISBN
	 * @throws IllegalISBNProvided If the publication is not found
	 */
	public Publication getPublication (String isbn) {
		return this.publications.stream()
			.filter(p -> p.getIsbn().equals(isbn))
			.findFirst()
			.orElseThrow(() -> new IllegalISBNProvided("Publication not found"));
	}

	/**
	 * Get all publications of a specific year
	 *
	 * @param publicationYear Year of the publications
	 * @return Set of all publications of the year
	 */
	public Set<Publication> getPublicationsOfYear (String publicationYear) {
		return this.publications.stream()
			.filter(p -> p.getPublicationYear().equals(publicationYear))
			.collect(Collectors.toSet());
	}

	/**
	 * Get all books of a specific author
	 *
	 * @param author Author of the books
	 * @return Set of all books of the author
	 */
	public Set<Book> getBooksOfAuthor (String author) {
		return this.getAllBooks().stream()
			.filter(book -> book.getAuthor().equals(author))
			.collect(Collectors.toSet());
	}

	/**
	 * Get all books of a specific genre
	 *
	 * @param genre genre of the books
	 * @return Set of all books of the genre
	 */
	public Set<Book> getBooksOfGenre (String genre) {
		return this.getAllBooks().stream()
			.filter(book -> book.getGenre().equals(genre))
			.collect(Collectors.toSet());
	}

	/**
	 * Get all magazines of a specific periodicity
	 *
	 * @param periodicity Periodicity of the magazines
	 * @return Set of all magazines of the periodicity
	 */
	public Set<Magazine> getMagazinesOfPeriodicity (Periodicity periodicity) {
		return this.getAllMagazine().stream()
			.filter(magazine -> magazine.getPeriodicity().equals(periodicity))
			.collect(Collectors.toSet());
	}

	// MODIFY

	/**
	 * Modify the title of a publication
	 *
	 * @param isbn  ISBN of the publication
	 * @param title New title of the publication
	 * @return True if the title was modified, false otherwise
	 * @see Publication#setTitle(String)
	 */
	public boolean modifyTitle (String isbn, String title) {
		try {
			Publication publication = this.getPublication(isbn);
			publication.setTitle(title);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Modify the publication year of a publication
	 *
	 * @param isbn            ISBN of the publication
	 * @param publicationYear New publication year of the publication
	 * @return True if the publication year was modified, false otherwise
	 * @see Publication#setPublicationYear(String)
	 */
	public boolean modifyPublicationYear (String isbn, String publicationYear) {
		try {
			Publication publication = this.getPublication(isbn);
			publication.setPublicationYear(publicationYear);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Modify the page count of a publication
	 *
	 * @param isbn      ISBN of the publication
	 * @param pageCount New page count of the publication
	 * @return True if the page count was modified, false otherwise
	 * @see Publication#setPageCount(int)
	 */
	public boolean modifyPageCount (String isbn, int pageCount) {
		try {
			Publication publication = this.getPublication(isbn);
			publication.setPageCount(pageCount);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Modify the author of a book
	 *
	 * @param isbn   ISBN of the book
	 * @param author New author of the book
	 * @return True if the author was modified, false otherwise
	 * @throws IllegalISBNProvided If the publication is not a book
	 * @see Book#setAuthor(String)
	 */
	public boolean modifyAuthor (String isbn, String author) {
		try {
			if (!(this.getPublication(isbn) instanceof Book book))
				throw new IllegalISBNProvided("Publication is not a book");
			book.setAuthor(author);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Modify the genre of a book
	 *
	 * @param isbn  ISBN of the book
	 * @param genre New genre of the book
	 * @return True if the genre was modified, false otherwise
	 * @throws IllegalISBNProvided If the publication is not a book
	 * @see Book#setGenre(String)
	 */
	public boolean modifyGenre (String isbn, String genre) {
		try {
			if (!(this.getPublication(isbn) instanceof Book book))
				throw new IllegalISBNProvided("Publication is not a book");
			book.setGenre(genre);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Modify the periodicity of a magazine
	 *
	 * @param isbn        ISBN of the magazine
	 * @param periodicity New periodicity of the magazine
	 * @return True if the periodicity was modified, false otherwise
	 * @throws IllegalISBNProvided If the publication is not a magazine
	 * @see Magazine#setPeriodicity(Periodicity)
	 */
	public boolean modifyPeriodicity (String isbn, Periodicity periodicity) {
		try {
			if (!(this.getPublication(isbn) instanceof Magazine magazine))
				throw new IllegalISBNProvided("Publication is not a magazine");
			magazine.setPeriodicity(periodicity);
			return true;
		} catch (IllegalISBNProvided _) {
			return false;
		}
	}

	/**
	 * Get the publication with the most pages
	 *
	 * @return Publication with the most pages
	 */
	public Publication getLongestPublication () {
		return this.publications.stream()
			.max(Comparator.comparing(Publication::getPageCount))
			.orElse(null);
	}

	/**
	 * Get the average page count of all publications
	 *
	 * @return Average page count of all publications
	 */
	public double getAveragePages () {
		return this.publications.stream()
			.collect(Collectors.averagingDouble(Publication::getPageCount));
	}

	// PRINT

	/**
	 * Print the statistics of the archive
	 * it will print the number of publications, the number of books and magazines,
	 * the longest publication and the average page count
	 */
	public void printStatistic () {
		System.out.printf("""
				STATISTICS (%d Publications):
				Books: %d
				Magazines: %d
				Longest Publication: %s
				Average Pages: %.2f
				""",
			this.publications.size(),
			this.getAllBooks().size(),
			this.getAllMagazine().size(),
			this.getLongestPublication(),
			this.getAveragePages()
		);
	}
}
