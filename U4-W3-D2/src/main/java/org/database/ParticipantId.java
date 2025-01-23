package org.database;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipantId implements Serializable {
   private Long eventId;
   private Long personId;

	public ParticipantId () {
   }

   public ParticipantId (Long eventId, Long personId) {
      this.eventId = eventId;
      this.personId = personId;
   }

   public Long getEventId () {
      return eventId;
   }

   public void setEventId (Long eventId) {
      this.eventId = eventId;
   }

   public Long getPersonId () {
      return personId;
   }

   public void setPersonId (Long personId) {
      this.personId = personId;
   }

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof ParticipantId that)) return false;
		return Objects.equals(getEventId(), that.getEventId()) && Objects.equals(getPersonId(), that.getPersonId());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getEventId(), getPersonId());
	}

	@Override
   public String toString () {
      return "ParticipantId{" +
         "eventId=" + eventId +
         ", personId=" + personId +
         '}';
   }
}