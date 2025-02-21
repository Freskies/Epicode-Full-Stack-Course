package org.events;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventRequest(
	@NotBlank (message = "Event name is mandatory")
	String name,
	@NotBlank (message = "Event description is mandatory")
	String description,
	@NotBlank (message = "Event location is mandatory")
	String location,
	@NotNull (message = "Event date is mandatory")
	LocalDate date,
	@NotBlank (message = "Max participants is mandatory")
	int maxParticipants
) {
}
