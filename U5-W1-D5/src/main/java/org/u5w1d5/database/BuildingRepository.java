package org.u5w1d5.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

	@Query (value = """
			SELECT DISTINCT b.city FROM buildings b
			ORDER BY b.city
		""")
	List<String> findDistinctCities();
}
