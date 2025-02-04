package menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class MenuItem {
	protected String name;
	protected double price;
	protected double calories;
}
