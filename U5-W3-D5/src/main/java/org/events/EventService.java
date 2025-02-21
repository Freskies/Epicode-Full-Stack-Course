package org.events;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.auth.AppUserRepository;
import org.jetbrains.annotations.NotNull;
import org.response.CreateResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Validated
public class EventService {
	private final EventRepository eventRepository;
	private final AppUserRepository appUserRepository;

	private @NotNull Long getCurrentUserId () {
		return this.appUserRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
			.get().getId();
	}

	public EventResponse eventResponseFromEvent (Event event) {
		EventResponse eventResponse = new EventResponse();
		BeanUtils.copyProperties(event, eventResponse);
		eventResponse.setOrganizer(this.appUserRepository.findById(event.getOrganizer().getId()).get());
		eventResponse.setParticipants(event.getParticipants().stream().map(
			participant -> this.appUserRepository.findById(participant.getId()).get()
		).toList());
		return eventResponse;
	}

	public List<EventResponse> eventResponseListFromEventList (@NotNull List<Event> events) {
		return events.stream().map(this::eventResponseFromEvent).toList();
	}

	public List<EventResponse> findAllEvents () {
		return this.eventResponseListFromEventList(this.eventRepository.findAll());
	}

	public EventResponse findEventById (Long id) {
		return this.eventResponseFromEvent(this.eventRepository.findById(id).get());
	}

	public Event eventFromEventRequest (@Valid EventRequest eventRequest) {
		Event event = new Event();
		BeanUtils.copyProperties(event, eventRequest);
		event.setParticipants(event.getParticipants().stream().map(
			participant -> this.appUserRepository.findById(participant.getId()).get()
		).toList());
		return event;
	}

	public CreateResponse save (@Valid EventRequest eventRequest) {
		Event event = this.eventFromEventRequest(eventRequest);
		event.setOrganizer(this.appUserRepository.findById(this.getCurrentUserId()).get());
		this.eventRepository.save(event);
		return new CreateResponse(event.getId());
	}

	public EventResponse update (@Valid EventRequest eventRequest, Long id) {
		Event event = this.eventFromEventRequest(eventRequest);
		if (!Objects.equals(event.getOrganizer().getId(), this.getCurrentUserId()))
			throw new SecurityException("You can only update your own events");
		event.setId(id);
		return this.eventResponseFromEvent(this.eventRepository.save(event));
	}

	public void delete (Long id) {
		Event event = this.eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));
		if (!Objects.equals(event.getOrganizer().getId(), this.getCurrentUserId()))
			throw new SecurityException("You can only delete your own events");
		this.eventRepository.delete(event);
	}

	public EventResponse subscribe (Long eventId) {
		Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EntityNotFoundException("Event not found"));
		if (event.getParticipants().stream().anyMatch(
			participant -> Objects.equals(participant.getId(), this.getCurrentUserId())
		))
			throw new EntityExistsException("You are already subscribed to this event");
		if (event.getParticipants().size() >= event.getMaxParticipants())
			throw new IllegalStateException("Event is full");
		event.getParticipants().add(this.appUserRepository.findById(this.getCurrentUserId()).get());
		return this.eventResponseFromEvent(this.eventRepository.save(event));
	}

	public EventResponse unsubscribe (Long eventId) {
		Event event = this.eventRepository.findById(eventId).orElseThrow(
			() -> new EntityNotFoundException("Event not found")
		);
		if (!event.getParticipants().removeIf(
			participant -> Objects.equals(participant.getId(), this.getCurrentUserId())
		))
			throw new EntityNotFoundException("You are not subscribed to this event");
		return this.eventResponseFromEvent(this.eventRepository.save(event));
	}

	public List<EventResponse> findMyEvents () {
		return this.eventResponseListFromEventList(this.eventRepository.findAllByOrganizerId(this.getCurrentUserId()));
	}

	public List<EventResponse> findSubscribedEvents () {
		return this.eventRepository.findAll().stream().filter(
			event -> event.getParticipants().stream().anyMatch(
				participant -> Objects.equals(participant.getId(), this.getCurrentUserId())
			)
		).map(this::eventResponseFromEvent).toList();
	}
}
