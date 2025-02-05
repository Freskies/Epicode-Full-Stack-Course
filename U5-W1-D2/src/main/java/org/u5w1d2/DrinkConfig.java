package org.u5w1d2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfig {

	@Bean
	public Drink milk() {
		Drink drink = new Drink();
		drink.setName("Milk");
		return drink;
	}
}
