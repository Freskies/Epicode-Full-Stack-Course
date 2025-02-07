package org.u5w1d5.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
	Building findByName (String name);
}
