package restourant.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import menu.MenuItem;
import restourant.Tables.Table;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Value ("${cover.charge}")
	public double COVER_CHARGE;

	private OrderStatus status;
	private int numberOfPeople;
	private Table table;
	private final List<MenuItem> items = new ArrayList<>();
	private double price;

	public void setStatus (OrderStatus status) {
		if (this.table == null) return;
		if (this.table.isOccupied())
			if (status != OrderStatus.SERVED)
				throw new IllegalStateException("Table is occupied");
		this.status = status;
	}

	public void addItems (MenuItem... items) {
		Collections.addAll(this.items, items);
		this.updatePrice();
	}

	private void updatePrice() {
		this.price = (this.COVER_CHARGE * this.numberOfPeople) +
			items.stream().mapToDouble(MenuItem::getPrice).sum();
	}
}
