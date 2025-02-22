package org.events;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.response.CreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/events")
@RequiredArgsConstructor
@PreAuthorize ("isAuthenticated()")
public class EventController {
	private final EventService eventService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<EventResponse> findAllEvents () {
		return this.eventService.findAllEvents();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public EventResponse findEventById (@PathVariable Long id) {
		return this.eventService.findEventById(id);
	}

	@GetMapping ("/myEvents")
	@ResponseStatus (HttpStatus.OK)
	@PreAuthorize ("hasRole('ORGANIZER')")
	public List<EventResponse> findMyEvents () {
		return this.eventService.findMyEvents();
	}

	@GetMapping ("/subscribedEvents")
	@ResponseStatus (HttpStatus.OK)
	public List<EventResponse> findSubscribedEvents () {
		return this.eventService.findSubscribedEvents();
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	@PreAuthorize ("hasRole('ORGANIZER')")
	public CreateResponse createEvent (@RequestBody @Valid EventRequest eventRequest) {
		return this.eventService.save(eventRequest);
	}

	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	@PreAuthorize ("hasRole('ORGANIZER')")
	public EventResponse updateEvent (@PathVariable Long id, @RequestBody EventRequest eventRequest) {
		return this.eventService.update(eventRequest, id);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	@PreAuthorize ("hasRole('ORGANIZER')")
	public void deleteEvent (@PathVariable Long id) {
		this.eventService.delete(id);
	}

	@PatchMapping ("/{id}/subscribe")
	@ResponseStatus (HttpStatus.OK)
	public EventResponse subscribe (@PathVariable Long id) {
		return this.eventService.subscribe(id);
	}

	@PatchMapping ("/{id}/unsubscribe")
	@ResponseStatus (HttpStatus.OK)
	public EventResponse unsubscribe (@PathVariable Long id) {
		return this.eventService.unsubscribe(id);
	}
}
