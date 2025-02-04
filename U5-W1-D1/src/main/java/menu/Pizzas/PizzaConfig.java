package menu.Pizzas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import menu.Toppings.ToppingConfig;

@Configuration
public class PizzaConfig {
	private final ToppingConfig toppingConfig = new ToppingConfig();

	@Bean
	public Pizza margherita() {
		Pizza p = new Pizza();
		p.setName("Margherita");
		p.addToppings(toppingConfig.cheese());
		p.setCalories(300);
		p.setPrice(8);
		return p;
	}

	@Bean
	public Pizza pepperoni() {
		Pizza p = new Pizza();
		p.setName("Pepperoni");
		p.addToppings(toppingConfig.cheese(), toppingConfig.pepperoni());
		p.setCalories(400);
		p.setPrice(10);
		return p;
	}

	@Bean
	public Pizza veggie() {
		Pizza p = new Pizza();
		p.setName("Veggie");
		p.addToppings(
			toppingConfig.cheese(),
			toppingConfig.pepperoni(),
			toppingConfig.mushrooms()
		);
		p.setCalories(350);
		p.setPrice(9);
		return p;
	}

	@Bean
	public Pizza meatLovers() {
		Pizza p = new Pizza();
		p.setName("Meat Lovers");
		p.addToppings(
			toppingConfig.cheese(),
			toppingConfig.mushrooms()
		);
		p.setCalories(450);
		p.setPrice(12);
		return p;
	}

	@Bean
	public Pizza mushroom() {
		Pizza p = new Pizza();
		p.setName("Mushroom");
		p.addToppings(
			toppingConfig.cheese(),
			toppingConfig.pepperoni(),
			toppingConfig.mushrooms(),
			toppingConfig.olives()
		);
		p.setCalories(320);
		p.setPrice(9);
		return p;
	}
}
