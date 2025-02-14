package org.u5w2d5.travel;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TravelRequest(
	@NotBlank (message = "Destination is mandatory")
	String destination,
	@NotNull (message = "Start date is mandatory")
	@FutureOrPresent (message = "Start date must be in the present or future")
	LocalDate startDate,
	@NotBlank (message = "State is mandatory")
	TravelState state
) {
}
