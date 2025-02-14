package org.u5w2d5.travel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelResponse {
	private String destination;
	private LocalDate startDate;
	private TravelState state;
}
