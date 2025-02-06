package org.u5w1d4;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.u5w1d4.drinks.Drink;
import org.u5w1d4.drinks.DrinkRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order (1)
public class Runner implements CommandLineRunner {
	private final DrinkRepository drinkRepository;

	@Override
	public void run (String... args) {
		List<Drink> drinks = List.of(
			new Drink("Coke", "Soda", 1.99),
			new Drink("Pepsi", "Soda", 1.99),
			new Drink("Sprite", "Soda", 1.99),
			new Drink("De La Louisiane", "Drink", 12),
			new Drink("Old Fashioned", "Drink", 10),
			new Drink("Sazerac", "Drink", 12)
		);

		drinkRepository.saveAll(drinks);

		drinkRepository.findAllByType("Soda").forEach(System.out::println);
	}
}
