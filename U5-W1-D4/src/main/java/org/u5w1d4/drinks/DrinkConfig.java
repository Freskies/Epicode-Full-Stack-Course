package org.u5w1d4.drinks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfig {

	@Bean
	public Drink coke() {
		return new Drink("Coke", "Soda", 1.99);
	}

	@Bean
	public Drink pepsi() {
		return new Drink("Pepsi", "Soda", 1.99);
	}

	@Bean
	public Drink sprite() {
		return new Drink("Sprite", "Soda", 1.99);
	}

	@Bean
	public Drink deLaLouisiane () {
		return new Drink("De La Louisiane", "Drink", 12);
	}

	@Bean
	public Drink oldFashioned () {
		return new Drink("Old Fashioned", "Drink", 10);
	}

	@Bean
	public Drink sazerac () {
		return new Drink("Sazerac", "Drink", 12);
	}
}
