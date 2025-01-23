package org.database;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "events")
public class Event {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "title")
	private String title;

	@Column (name = "event_date")
	private LocalDate eventDate;

	@Column (name = "description")
	private String description;

	@Column (name = "event_type")
	@Enumerated (EnumType.STRING)
	private EventType eventType;

	@Column (name = "max_participants")
	private Integer maxParticipants;

	@ManyToOne
	@JoinColumn (name = "location_id")
	private Location location;

	@OneToMany (mappedBy = "event", cascade = CascadeType.ALL)
	private Set<Participant> participants = new LinkedHashSet<>();

	public Event () {
	}

	public Event (
		String title,
		LocalDate eventDate,
		String description,
		EventType eventType,
		Integer maxParticipants,
		Location location
	) {
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.eventType = eventType;
		this.maxParticipants = maxParticipants;
		this.location = location;
	}

	public Long getId () {
		return this.id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getTitle () {
		return this.title;
	}

	public void setTitle (String title) {
		this.title = title;
	}

	public LocalDate getEventDate () {
		return this.eventDate;
	}

	public void setEventDate (LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription () {
		return this.description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public EventType getEventType () {
		return this.eventType;
	}

	public void setEventType (EventType eventType) {
		this.eventType = eventType;
	}

	public Integer getMaxParticipants () {
		return this.maxParticipants;
	}

	public void setMaxParticipants (Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public Location getLocation () {
		return this.location;
	}

	public void setLocation (Location location) {
		this.location = location;
	}

	@Override
	public String toString () {
		return "Event{" +
			"id=" + getId() +
			", title='" + getTitle() + '\'' +
			", eventDate=" + getEventDate() +
			", description='" + getDescription() + '\'' +
			", eventType=" + getEventType() +
			", maxParticipants=" + getMaxParticipants() +
			", location=" + getLocation() +
			'}';
	}

	public Set<Participant> getParticipants () {
		return participants;
	}

	public void setParticipants (Set<Participant> participants) {
		this.participants = participants;
	}
}