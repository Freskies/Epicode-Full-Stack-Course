package menu.Pizzas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import menu.MenuItem;
import menu.Toppings.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode (callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza extends MenuItem {
	protected List<Topping> toppings = new ArrayList<>();

	public void addToppings (Topping... topping) {
		this.toppings.addAll(Arrays.asList(topping));
	}
}
