package org.database;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "genres")
public class Genre {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Integer id;

	@Column (name = "genre", nullable = false, length = 50)
	private String genre;

	@OneToMany (mappedBy = "genre")
	private Set<Book> books = new LinkedHashSet<>();

	public Genre () {
	}

	public Genre (String genre) {
		this.genre = genre;
	}

	public Set<Book> getBooks () {
		return books;
	}

	public void setBooks (Set<Book> books) {
		this.books = books;
	}

	public String getGenre () {
		return genre;
	}

	public void setGenre (String genre) {
		this.genre = genre;
	}

	public Integer getId () {
		return id;
	}

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Genre genre1)) return false;
		return Objects.equals(getId(), genre1.getId()) && Objects.equals(getGenre(), genre1.getGenre());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getGenre(), getBooks());
	}

	@Override
	public String toString () {
		return "Genre{" +
			"id=" + getId() +
			", genre='" + getGenre() + '\'' +
			'}';
	}
}
