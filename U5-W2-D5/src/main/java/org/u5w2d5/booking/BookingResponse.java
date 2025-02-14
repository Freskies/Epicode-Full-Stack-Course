package org.u5w2d5.booking;

import org.u5w2d5.employee.Employee;
import org.u5w2d5.travel.Travel;

import java.time.LocalDate;

public class BookingResponse {
	private Long id;
	private LocalDate requestedAt;
	private String notes;
	private Travel travel;
	private Employee employee;
}
