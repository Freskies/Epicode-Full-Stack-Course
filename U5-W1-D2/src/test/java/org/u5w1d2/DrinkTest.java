package org.u5w1d2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DrinkTest {
	@Autowired private Drink milk;

	@Test
	public void testMilk() {
		assertEquals("Milk", milk.getName());
	}

	@ParameterizedTest
	@CsvSource({"Ciola", "Cacca", "Puzza"})
	@DisplayName("Test Drinks ez")
	public void testMilkEz(String name) {
		Drink drink = new Drink(name);
		assertEquals(name, drink.getName());
	}
}
