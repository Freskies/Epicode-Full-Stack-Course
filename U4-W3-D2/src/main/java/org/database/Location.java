package org.database;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "location")
public class Location {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (name = "location_id", nullable = false)
	private Integer id;

	@Column (name = "name", nullable = false, length = 50)
	private String name;

	@Column (name = "address", nullable = false, length = 50)
	private String address;

	@OneToMany (mappedBy = "location", cascade = CascadeType.ALL)
	private Set<Event> events = new LinkedHashSet<>();

	public Location () {
	}

	public Location (String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Set<Event> getEvents () {
		return events;
	}

	public void setEvents (Set<Event> events) {
		this.events = events;
	}

	public String getAddress () {
		return address;
	}

	public void setAddress (String address) {
		this.address = address;
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

	public void setId (Integer id) {
		this.id = id;
	}

	@Override
	public String toString () {
		return "Location{" +
			"id=" + getId() +
			", name='" + getName() + '\'' +
			", address='" + getAddress() + '\'' +
			'}';
	}
}
