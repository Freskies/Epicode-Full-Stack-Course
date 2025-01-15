import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		Customer customer = new Customer(1L, "John Doe", 1);
		Customer customer1 = new Customer(1L, "Alice", 2);

		List<Product> products = Arrays.asList(
			new Product(1L, "Harry Potter", "Books", 100.0),
			new Product(1L, "Jobless Reincarnation", "Books", 120.0),
			new Product(2L, "Mario", "Toys", 200.0),
			new Product(3L, "Keyboard", "IT", 300.0),
			new Product(3L, "Diaper", "Baby", 20.0),
			new Product(3L, "Diaper of GOD", "Baby", 399.89),
			new Product(3L, "Diaper", "Boys", 20.0),
			new Product(3L, "Lego NinjaGO", "Boys", 399.89)
		);

		List<Product> products2 = Arrays.asList(
			new Product(1L, "Harry Potter", "Books", 100.0),
			new Product(1L, "Jobless Reincarnation", "Books", 120.0),
			new Product(2L, "Mario", "Toys", 200.0),
			new Product(3L, "Keyboard", "IT", 300.0)
		);

		List<Order> orders = Arrays.asList(
			new Order(
				"Pending",
				LocalDate.now(),
				LocalDate.now().plusDays(5),
				products,
				customer
			),
			new Order(
				"Pending",
				LocalDate.now(),
				LocalDate.now().plusDays(5),
				products,
				customer1
			),
			new Order(
				"Pending",
				LocalDate.now(),
				LocalDate.now().plusDays(5),
				products2,
				customer
			),
			new Order(
				"Pending",
				LocalDate.of(2021, 3, 1),
				LocalDate.of(2021, 3, 5),
				products2,
				customer1
			)
		);

		// ES 1
		System.out.print("Exercise 1: ");
		List<Product> booksGT100 = products.stream().filter(
			product -> product.category.equals("Books") && product.price > 100
		).toList();
		System.out.println(booksGT100);

		// ES 2
		System.out.print("Exercise 2: ");
		List<Order> orderWithBabyProducts = orders.stream().filter(
			order -> order.products.stream().anyMatch(
				product -> product.category.equals("Baby")
			)
		).toList();
		System.out.println(orderWithBabyProducts);

		// ES 3
		System.out.print("Exercise 3: ");
		List<Product> boysProduct = products.stream().filter(
			product -> product.category.equals("Boys")
		).toList();
		List<Product> boysDiscount = boysProduct.stream().map(
			product -> new Product(
				product.id,
				product.name,
				product.category,
				product.price * 0.9
			)
		).toList();
		System.out.print(boysProduct + " -> ");
		System.out.println(boysDiscount);

		// ES 4
		System.out.print("Exercise 4: ");
		List<Product> orderedByVIPS = orders.stream()
			.filter(order -> order.customer.tier == 2 &&
					order.orderDate.isAfter(LocalDate.of(2021, 2, 1)) &&
					order.orderDate.isBefore(LocalDate.of(2021, 4, 1))
			)
			.flatMap(order -> order.products.stream())
			.toList();
		System.out.println(orderedByVIPS);

		System.out.print("Exercise 4+: ");
		List<Product> orderedByVIPS2 = orders.stream()
			.filter(order -> order.customer.tier == 2 &&
				order.orderDate.isAfter(LocalDate.of(2021, 2, 1)) &&
				order.orderDate.isBefore(LocalDate.of(2021, 4, 1))
			)
			.reduce(
				new ArrayList<>(),
				(List<Product> acc, Order order) -> {
					acc.addAll(order.products);
					return acc;
				},
				(acc1, acc2) -> {
					acc1.addAll(acc2);
					return acc1;
				}
			);
		System.out.println(orderedByVIPS2);
	}
}