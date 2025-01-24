package org.database;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "card_number", nullable = false)
	private Long id;

	@Column (name = "name", nullable = false, length = 50)
	private String name;

	@Column (name = "surname", nullable = false, length = 50)
	private String surname;

	@Column (name = "birth", nullable = false)
	private LocalDate birth;

	@OneToMany (mappedBy = "user")
	private Set<Loan> loans = new LinkedHashSet<>();

	public User () {
	}

	public User (String name, String surname, LocalDate birth) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}

	public Set<Loan> getLoans () {
		return loans;
	}

	public void setLoans (Set<Loan> loans) {
		this.loans = loans;
	}

	public LocalDate getBirth () {
		return birth;
	}

	public void setBirth (LocalDate birth) {
		this.birth = birth;
	}

	public String getSurname () {
		return surname;
	}

	public void setSurname (String surname) {
		this.surname = surname;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Long getId () {
		return id;
	}

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof User user)) return false;
		return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getBirth(), user.getBirth());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getName(), getSurname(), getBirth());
	}

	@Override
	public String toString () {
		return "User{" +
			"id=" + getId() +
			", name='" + getName() + '\'' +
			", surname='" + getSurname() + '\'' +
			", birth=" + getBirth() +
			", loans=" + getLoans() +
			'}';
	}
}