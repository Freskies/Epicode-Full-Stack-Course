package org.database;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "persons")
public class Person {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "first_name")
	private String firstName;

	@Column (name = "last_name")
	private String lastName;

	@Column (name = "email")
	private String email;

	@Column (name = "birth_date")
	private LocalDate birthDate;

	@Column (name = "sex")
	@Enumerated (EnumType.STRING)
	private Sex sex;

	@OneToMany (mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Participant> participants = new LinkedHashSet<>();

	public Person () {
	}

	public Person (
		String firstName,
		String lastName,
		String email,
		LocalDate birthDate,
		Sex sex
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public Long getId () {
		return id;
	}

	public String getFirstName () {
		return firstName;
	}

	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getLastName () {
		return lastName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public String getEmail () {
		return email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public LocalDate getBirthDate () {
		return birthDate;
	}

	public void setBirthDate (LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Sex getSex () {
		return sex;
	}

	public void setSex (Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString () {
		return "Person{" +
			"id=" + getId() +
			", firstName='" + getFirstName() + '\'' +
			", lastName='" + getLastName() + '\'' +
			", email='" + getEmail() + '\'' +
			", birthDate=" + getBirthDate() +
			", sex=" + getSex() +
			'}';
	}

	public Set<Participant> getParticipants () {
		return participants;
	}

	public void setParticipants (Set<Participant> participants) {
		this.participants = participants;
	}
}
