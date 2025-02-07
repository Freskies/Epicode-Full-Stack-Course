package org.u5w1d5.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findAllByUserOrderByReservationDateAsc (User loggedUser);

	boolean existsByUserAndReservationDate (User user, LocalDate reservationDate);
}
