package org.events;

import lombok.RequiredArgsConstructor;
import org.auth.AppUser;
import org.auth.AppUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class EventService {
	private final EventRepository eventRepository;
	private final AppUserRepository appUserRepository;

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
}
