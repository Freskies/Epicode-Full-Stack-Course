package org.u5w2d5.booking;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookingRequest(
	@NotNull (message = "requestedAt is required")
	LocalDate requestedAt,
	String notes,
	@NotNull (message = "travelId is required")
	Long travelId,
	@NotNull (message = "employeeId is required")
	Long employeeId
) {
}
