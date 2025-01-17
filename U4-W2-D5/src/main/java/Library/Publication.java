package Library;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication {
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

	public String getIsbn () {
		return this.isbn;
	}

	// TITLE

	public String getTitle () {
		return this.title;
	}

	public void setTitle (String title) {
		if (title.isBlank())
			throw new IllegalArgumentException("Title must not be blank");
		if (!title.matches("[a-zA-Z0-9 ]+"))
			throw new IllegalArgumentException("Title must contain only letters, numbers and spaces");
		this.title = title.trim();
	}

	// PUBLICATION YEAR

	public String getPublicationYear () {
		return this.publicationYear;
	}

	public void setPublicationYear (String publicationYear) {
		if (publicationYear.length() != 4)
			throw new IllegalArgumentException("Publication year must be 4 digits");
		if (!publicationYear.matches("[0-9]+"))
			throw new IllegalArgumentException("Publication year must be a number");
		if (Integer.parseInt(publicationYear) > LocalDate.now().getYear())
			throw new IllegalArgumentException("Publication year must not be in the future");
		this.publicationYear = publicationYear;
	}

	// PAGE COUNT

	public int getPageCount () {
		return this.pageCount;
	}

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
