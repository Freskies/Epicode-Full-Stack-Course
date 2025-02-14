package org.u5w2d5.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.u5w2d5.employee.Employee;
import org.u5w2d5.travel.Travel;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
	private Long id;
	private LocalDate requestedAt;
	private String notes;
	private Travel travel;
	private Employee employee;
}
