package menu;

import menu.Pizzas.Pizza;
import menu.Pizzas.PizzaConfig;
import menu.Toppings.ToppingConfig;
import menu.drinks.DrinkConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {
	@Bean
	public Menu menu () {
		DrinkConfig drinkConfig = new DrinkConfig();
		PizzaConfig pizzaConfig = new PizzaConfig();
		ToppingConfig toppingConfig = new ToppingConfig();

		Menu m = new Menu();
		m.addItems(
			drinkConfig.redHook(),
			drinkConfig.cola(),
			drinkConfig.lemonade(),
			drinkConfig.icedTea(),
			pizzaConfig.margherita(),
			pizzaConfig.pepperoni(),
			pizzaConfig.veggie(),
			toppingConfig.olives(),
			toppingConfig.pepperoni(),
			toppingConfig.mushrooms(),
			toppingConfig.cheese()
		);

		return m;
	}
}
