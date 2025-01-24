package org.database;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "authors")
public class Author {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Integer id;

	@Column (name = "name", nullable = false, length = 50)
	private String name;

	@OneToMany (mappedBy = "author")
	private Set<Book> books = new LinkedHashSet<>();

	public Author () {
	}

	public Author (String name) {
		this.name = name;
	}

	public Set<Book> getBooks () {
		return books;
	}

	public void setBooks (Set<Book> books) {
		this.books = books;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Integer getId () {
		return id;
	}

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Author author)) return false;
		return Objects.equals(getId(), author.getId()) && Objects.equals(getName(), author.getName());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getName());
	}

	@Override
	public String toString () {
		return "Author{" +
			"id=" + getId() +
			", name='" + getName() + '\'' +
			'}';
	}
}
