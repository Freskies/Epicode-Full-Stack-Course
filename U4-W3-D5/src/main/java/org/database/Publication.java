package org.database;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Publication {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "isbn", nullable = false)
	private Integer isbn;

	@Column (name = "title", nullable = false, length = 50)
	private String title;

	@Column (name = "year_of_publication", nullable = false)
	private int yearOfPublication;

	@Column (name = "pages", nullable = false)
	private int pages;

	@OneToMany (mappedBy = "isbn")
	private Set<Loan> loans = new LinkedHashSet<>();

	public Publication () {
	}

	public Publication (String title, int yearOfPublication, int pages) {
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.pages = pages;
	}

	public Set<Loan> getLoans () {
		return loans;
	}

	public void setLoans (Set<Loan> loans) {
		this.loans = loans;
	}

	public Integer getPages () {
		return pages;
	}

	public void setPages (Integer pages) {
		this.pages = pages;
	}

	public Integer getYearOfPublication () {
		return yearOfPublication;
	}

	public void setYearOfPublication (Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getTitle () {
		return title;
	}

	public void setTitle (String title) {
		this.title = title;
	}

	public Integer getIsbn () {
		return isbn;
	}

	@Override
	public boolean equals (Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Publication that = (Publication) o;
		return Objects.equals(getIsbn(), that.getIsbn()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getYearOfPublication(), that.getYearOfPublication()) && Objects.equals(getPages(), that.getPages());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getIsbn(), getTitle(), getYearOfPublication(), getPages());
	}

	@Override
	public String toString () {
		return "Publication{" +
			"id=" + getIsbn() +
			", title='" + getTitle() + '\'' +
			", yearOfPublication=" + getYearOfPublication() +
			", pages=" + getPages() +
			'}';
	}
}
