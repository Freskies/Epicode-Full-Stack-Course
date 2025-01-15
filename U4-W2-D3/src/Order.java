import java.time.LocalDate;
import java.util.List;

public class Order {
	public Long id;
	public String status;
	public LocalDate orderDate;
	public LocalDate deliveryDate;
	public List<Product> products;
	public Customer customer;

	public Order(
		String status,
		LocalDate orderDate,
		LocalDate deliveryDate,
		List<Product> products,
		Customer customer
	){
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}
}
