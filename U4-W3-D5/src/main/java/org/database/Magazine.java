package org.database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "magazines")
public class Magazine extends Publication {

	@Column (name = "periodicity", columnDefinition = "t_periodicity not null")
	@Enumerated (EnumType.STRING)
	private Periodicity periodicity;

	public Magazine () {
	}

	public Magazine (String title, int yearOfPublication, int pages, Periodicity periodicity) {
		super(title, yearOfPublication, pages);
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity () {
		return periodicity;
	}

	public void setPeriodicity (Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public boolean equals (Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Magazine magazine = (Magazine) o;
		return getPeriodicity() == magazine.getPeriodicity();
	}

	@Override
	public int hashCode () {
		return Objects.hash(super.hashCode(), getPeriodicity());
	}

	@Override
	public String toString () {
		return "Magazine{" +
			"isbn=" + getIsbn() +
			", title='" + getTitle() + '\'' +
			", yearOfPublication=" + getYearOfPublication() +
			", periodicity=" + getPeriodicity() +
			'}';
	}
}
