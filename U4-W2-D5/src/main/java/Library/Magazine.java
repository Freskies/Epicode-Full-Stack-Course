package Library;

public class Magazine extends Publication {
	private Periodicity periodicity;

	// CONSTRUCTORS

	public Magazine (
		String isbn,
		String title,
		String publicationYear,
		int pageCount,
		Periodicity periodicity
	) {
		super(isbn, title, publicationYear, pageCount);
		this.setPeriodicity(periodicity);
	}

	// PERIODICITY

	/**
	 * Get the periodicity of the magazine
	 *
	 * @return the periodicity of the magazine
	 */
	public Periodicity getPeriodicity () {
		return this.periodicity;
	}

	/**
	 * Set the periodicity of the magazine
	 *
	 * @param periodicity the periodicity of the magazine
	 * @throws IllegalArgumentException if the periodicity is null
	 */
	public void setPeriodicity (Periodicity periodicity) {
		if (periodicity == null)
			throw new IllegalArgumentException("Periodicity cannot be null");
		this.periodicity = periodicity;
	}

	// OVERRIDE

	@Override
	public String toString () {
		return "Magazine{" +
			"periodicity=" + getPeriodicity() +
			", isbn='" + getIsbn() + '\'' +
			", title='" + getTitle() + '\'' +
			", publicationYear='" + getPublicationYear() + '\'' +
			", pageCount=" + getPageCount() +
			'}';
	}
}
