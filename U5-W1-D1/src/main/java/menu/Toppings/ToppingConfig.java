package menu.Toppings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

	@Bean(name = "cheese")
	public Topping cheese () {
		Topping t = new Topping();
		t.setName("Cheese");
		t.setCalories(200);
		t.setPrice(1.5);
		return t;
	}

	@Bean
	public Topping pepperoni () {
		Topping t = new Topping();
		t.setName("Pepperoni");
		t.setCalories(150);
		t.setPrice(2);
		return t;
	}

	@Bean
	public Topping mushrooms () {
		Topping t = new Topping();
		t.setName("Mushrooms");
		t.setCalories(20);
		t.setPrice(1);
		return t;
	}

	@Bean
	public Topping olives () {
		Topping t = new Topping();
		t.setName("Olives");
		t.setCalories(50);
		t.setPrice(1.2);
		return t;
	}
}
