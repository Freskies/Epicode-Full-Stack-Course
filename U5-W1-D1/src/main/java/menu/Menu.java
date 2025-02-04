package menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import menu.Pizzas.Pizza;
import menu.Toppings.Topping;
import menu.drinks.Drink;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	private List<Pizza> pizzaList = new ArrayList<>();
	private List<Drink> drinkList = new ArrayList<>();
	private List<Topping> toppingList = new ArrayList<>();

	public void addItems (MenuItem @NotNull ... items) {
		for (MenuItem item : items)
			switch (item) {
				case null -> throw new IllegalArgumentException("Item cannot be null");
				case Pizza pizza -> pizzaList.add(pizza);
				case Drink drink -> drinkList.add(drink);
				case Topping topping -> toppingList.add(topping);
				default -> throw new IllegalArgumentException("Invalid item type");
			}
	}
}
