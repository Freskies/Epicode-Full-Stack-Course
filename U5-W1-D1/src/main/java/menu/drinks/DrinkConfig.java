package menu.drinks;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfig {

	@Bean
	public Drink redHook () {
		Drink d = new Drink();
		d.setName("Red Hook");
		d.setQuantity(33);
		d.setCalories(10);
		d.setPrice(12);
		return d;
	}

	@Bean
	public Drink cola () {
		Drink d = new Drink();
		d.setName("Cola");
		d.setQuantity(500);
		d.setCalories(210);
		d.setPrice(2);
		return d;
	}

	@Bean
	public Drink lemonade () {
		Drink d = new Drink();
		d.setName("Lemonade");
		d.setQuantity(300);
		d.setCalories(120);
		d.setPrice(3);
		return d;
	}

	@Bean
	public Drink icedTea () {
		Drink d = new Drink();
		d.setName("Iced Tea");
		d.setQuantity(400);
		d.setCalories(90);
		d.setPrice(2.5);
		return d;
	}
}
