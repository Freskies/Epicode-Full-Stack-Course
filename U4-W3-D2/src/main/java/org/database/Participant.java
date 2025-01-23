package org.database;

import jakarta.persistence.*;

@Entity
@Table (name = "event_participants")
public class Participant {

	@EmbeddedId
	private ParticipantId id = new ParticipantId();

	@MapsId ("eventId")
	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@JoinColumn (name = "event_id", nullable = false)
	private Event event;

	@MapsId ("personId")
	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@JoinColumn (name = "person_id", nullable = false)
	private Person person;

	@Column (name = "state")
	@Enumerated (EnumType.STRING)
	private State state;

	public Participant () {
	}

	public Participant (Event event, Person person, State state) {
		this.id.setEventId(event.getId());
		this.id.setPersonId(person.getId());
		this.event = event;
		this.person = person;
		this.state = state;
	}

	public Person getPerson () {
		return person;
	}

	public void setPerson (Person person) {
		this.person = person;
	}

	public Event getEvent () {
		return event;
	}

	public void setEvent (Event event) {
		this.event = event;
	}

	public ParticipantId getId () {
		return id;
	}

	public void setId (ParticipantId id) {
		this.id = id;
	}

	public State getState () {
		return state;
	}

	public void setState (State state) {
		this.state = state;
	}

	@Override
	public String toString () {
		return "Participant{" +
			"id=" + getId() +
			", event=" + getEvent() +
			", person=" + getPerson() +
			", state=" + this.getState() +
			'}';
	}
}
