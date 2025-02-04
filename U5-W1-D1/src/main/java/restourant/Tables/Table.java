package restourant.Tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
	private int tableNumber;
	private TableStatus status;

	public boolean isOccupied() {
		return this.status == TableStatus.OCCUPIED;
	}
}
