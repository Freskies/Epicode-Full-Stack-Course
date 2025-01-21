package org.events;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "event_date")
	private LocalDate eventDate;

	@Column(name = "description")
	private String description;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "max_participants")
	private int maxParticipants;

	public Event () {}

	public Event (
		String title,
		LocalDate eventDate,
		String description,
		EventType eventType,
		Integer maxParticipants
	) {
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.eventType = eventType.toString();
		this.maxParticipants = maxParticipants;
	}

	public Long getId () {
		return this.id;
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
		return EventType.valueOf(this.eventType.toUpperCase());
	}

	public void setEventType (EventType eventType) {
		this.eventType = eventType.toString();
	}

	public int getMaxParticipants () {
		return this.maxParticipants;
	}

	public void setMaxParticipants (int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	@Override
	public String toString () {
		return "org.events.Event{" +
			"id=" + getId() +
			", title='" + getTitle() + '\'' +
			", eventDate=" + getEventDate() +
			", description='" + getDescription() + '\'' +
			", eventType='" + getEventType() + '\'' +
			", maxParticipants=" + getMaxParticipants() +
			'}';
	}
}
