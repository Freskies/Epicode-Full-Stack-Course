package org.example.u5w1d1.conf;

import menu.drinks.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DrinkConfigTest {
	@Autowired
	Drink redHook;

	@Test
	@DisplayName("Red Hook drink test")
	public void redHookTest() {
		assert redHook.getName().equals("Red Hook");
		assert redHook.getQuantity() == 33;
		assert redHook.getCalories() == 10;
		assert redHook.getPrice() == 12;
	}
}
