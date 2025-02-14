package org.u5w2d5.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.u5w2d5.employee.Employee;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	boolean existsByEmployeeAndTravelStartDate (Employee employee, LocalDate travelStartDate);

	// you cannot reserve a travel in a travel date less than now
}
