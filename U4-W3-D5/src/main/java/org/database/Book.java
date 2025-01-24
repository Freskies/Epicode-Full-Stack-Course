package org.database;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Table (name = "books")
public class Book extends Publication {

	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@OnDelete (action = OnDeleteAction.SET_NULL)
	@JoinColumn (name = "genre_id", nullable = false)
	private Genre genre;

	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@OnDelete (action = OnDeleteAction.SET_NULL)
	@JoinColumn (name = "author_id", nullable = false)
	private Author author;

	public Book () {
		super();
	}

	public Book (String title, int yearOfPublication, int pages, Author author, Genre genre) {
		super(title, yearOfPublication, pages);
		this.author = author;
		this.genre = genre;
	}

	public Author getAuthor () {
		return author;
	}

	public void setAuthor (Author author) {
		this.author = author;
	}

	public Genre getGenre () {
		return genre;
	}

	public void setGenre (Genre genre) {
		this.genre = genre;
	}

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Book book)) return false;
		if (!super.equals(o)) return false;
		return Objects.equals(getGenre(), book.getGenre()) && Objects.equals(getAuthor(), book.getAuthor());
	}

	@Override
	public int hashCode () {
		return Objects.hash(super.hashCode(), getGenre(), getAuthor());
	}

	@Override
	public String toString () {
		return "Book{" +
			"ISBN=" + super.getIsbn() +
			", title=" + super.getTitle() +
			", yearOfPublication=" + super.getYearOfPublication() +
			", genre=" + this.getGenre() +
			", author=" + this.getAuthor() +
			'}';
	}
}