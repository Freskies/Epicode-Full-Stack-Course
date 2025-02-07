package org.u5w1d5.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
	List<Workstation> findAllByType (WorkstationType type);

	@Query (value = """
		SELECT w FROM workstations w
		WHERE w.id NOT IN (
			SELECT r.workstation.id FROM reservations r
			WHERE r.reservationDate = :date
		)
	""")
	List<Workstation> findAllNotReservedOnDate (LocalDate date);

	@Query (value = """
		SELECT w FROM workstations w
		WHERE w.id NOT IN (
			SELECT r.workstation.id FROM reservations r
			WHERE r.reservationDate = :date
		)
		AND w.type = :type
	""")
	List<Workstation> findAllNotReservedOnDateAndType (LocalDate date, WorkstationType type);

	@Query (value = """
		SELECT w FROM workstations w
		WHERE w.id NOT IN (
			SELECT r.workstation.id FROM reservations r
			WHERE r.reservationDate = :date
		)
		AND w.building.city = :city
	""")
	List<Workstation> findAllNotReservedOnDateAndCity (LocalDate date, String city);

	@Query (value = """
		SELECT w FROM workstations w
		WHERE w.id NOT IN (
			SELECT r.workstation.id FROM reservations r
			WHERE r.reservationDate = :date
		)
		AND w.type = :type
		AND w.building.city = :city
	""")
	List<Workstation> findAllNotReservedOnDateAndTypeAndCity (LocalDate date, WorkstationType type, String city);

}
