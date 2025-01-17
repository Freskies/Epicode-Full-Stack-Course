package Library;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication {
	private static final int WRITING_INVENTION_YEAR = -3200;
	private final String isbn;
	private String title;
	private String publicationYear;
	private int pageCount;

	// CONSTRUCTORS

	protected Publication (String isbn, String title, String publicationYear, int pageCount) {
		this.isbn = isbn;
		this.setTitle(title);
		this.setPublicationYear(publicationYear);
		this.setPageCount(pageCount);
	}

	// ISBN

	/**
	 * get the ISBN of the publication
	 *
	 * @return the ISBN of the publication
	 */
	public String getIsbn () {
		return this.isbn;
	}

	// TITLE

	/**
	 * get the title of the publication
	 *
	 * @return the title of the publication
	 */
	public String getTitle () {
		return this.title;
	}

	/**
	 * set the title of the publication
	 * the title must not be blank and
	 * can contain only letters, numbers and spaces
	 *
	 * @param title the title of the publication
	 * @throws IllegalArgumentException if the title is invalid
	 */
	public void setTitle (String title) {
		if (title.isBlank())
			throw new IllegalArgumentException("Title must not be blank");
		if (!title.matches("[a-zA-Z0-9 ]+"))
			throw new IllegalArgumentException("Title must contain only letters, numbers and spaces");
		this.title = title.trim();
	}

	// PUBLICATION YEAR

	/**
	 * get the publication year of the publication
	 *
	 * @return the publication year of the publication
	 */
	public String getPublicationYear () {
		return this.publicationYear;
	}

	/**
	 * set the publication year of the publication.
	 * The publication year must not be before the invention of writing
	 * and must not be in the future
	 *
	 * @param publicationYear the publication year of the publication
	 * @throws IllegalArgumentException if the publication year is invalid
	 */
	public void setPublicationYear (String publicationYear) {
		if (Integer.parseInt(publicationYear) < Publication.WRITING_INVENTION_YEAR)
			throw new IllegalArgumentException("Publication year must not be before the invention of writing");
		if (Integer.parseInt(publicationYear) > LocalDate.now().getYear())
			throw new IllegalArgumentException("Publication year must not be in the future");
		this.publicationYear = publicationYear;
	}

	// PAGE COUNT

	/**
	 * get the page count of the publication
	 *
	 * @return the page count of the publication
	 */
	public int getPageCount () {
		return this.pageCount;
	}

	/**
	 * set the page count of the publication
	 * the page count must be a positive number
	 *
	 * @param pageCount the page count of the publication
	 * @throws IllegalArgumentException if the page count is invalid
	 */
	public void setPageCount (int pageCount) {
		if (pageCount < 1)
			throw new IllegalArgumentException("Page count must be a positive number");
		this.pageCount = pageCount;
	}

	// OVERRIDE

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Publication that)) return false;
		return Objects.equals(getIsbn(), that.getIsbn());
	}

	@Override
	public int hashCode () {
		return Objects.hashCode(getIsbn());
	}

	@Override
	public String toString () {
		return "Publication{" +
			"isbn='" + isbn + '\'' +
			", title='" + getTitle() + '\'' +
			", publicationYear='" + getPublicationYear() + '\'' +
			", pageCount=" + getPageCount() +
			'}';
	}
}
