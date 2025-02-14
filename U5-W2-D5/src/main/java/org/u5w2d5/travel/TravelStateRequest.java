package org.u5w2d5.travel;

import jakarta.validation.constraints.NotNull;

public record TravelStateRequest (
	@NotNull (message = "state is mandatory")
	TravelState state
){
}
