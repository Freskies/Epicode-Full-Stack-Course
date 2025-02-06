package org.u5w1d4.drinks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
	Drink findByName (String name);
	List<Drink> findAllByType (String type);

	boolean existsByName (String name);
	boolean existsByType (String type);
	boolean existsByPrice (double price);

	int countDistinctByType (String type);
}
