package menu.drinks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import menu.MenuItem;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode (callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drink extends MenuItem {
	protected double quantity;
}
