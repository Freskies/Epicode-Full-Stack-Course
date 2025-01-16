package org;

import Shop.Customer;
import Shop.Order;
import Shop.Product;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
	public static void main (String[] args) {
		// CUSTOMERS
		Customer alice = new Customer("Alice");
		Customer bob = new Customer("Bob");
		Customer charlie = new Customer("Charlie", 2);

		// PRODUCTS
		Product apple = new Product("Apple", "Fruit", 1.0);
		Product banana = new Product("Banana", "Fruit", 1.5);
		Product carrot = new Product("Carrot", "Vegetable", 0.5);
		Product donut = new Product("Donut", "Pastry", 2.0);
		Product pencil = new Product("Pencil", "Stationery", 2.25);
		Product tshirt = new Product("T-Shirt", "Clothing", 10.0);

		// ORDERS
		Order order1 = new Order(alice);
		order1.addProduct(apple, 3);
		order1.addProduct(banana);
		order1.addProduct(carrot);
		order1.order();

		Order order2 = new Order(bob, LocalDate.of(2021, 1, 1));
		order2.addProduct(donut);

		Order order3 = new Order(
			charlie,
			LocalDate.of(2021, 1, 1),
			LocalDate.of(2021, 1, 2)
		);
		order3.addProduct(pencil);
		order3.addProduct(tshirt);

		Order order4 = new Order(alice);
		order4.addProduct(apple, 2);
		order4.addProduct(pencil);

		Shop shop = new Shop(order1, order2, order3, order4);
		//Shop shop = new Shop(order4);

		// ES 1
		System.out.println("ES1");
		System.out.println(shop.getAllOrderGroupedByCustomers());

		// ES 2
		System.out.println("\nES2");
		System.out.println(shop.getTotalPerCustomer());

		// ES 3
		System.out.println("\nES3");
		System.out.println(Product.getMostExpensiveProductOf(
			Arrays.asList(apple, banana, carrot, donut)
		));

		// ES 4
		System.out.println("\nES4");
		System.out.printf("%.2f€\n", shop.getAverageTotal());

		// ES 5
		System.out.println("\nES5");
		System.out.println(Product.getPricesPerCategory(
			Arrays.asList(apple, banana, carrot, donut)
		));

		// ES 6
		try {
			Product.saveProductsInFile(
				Arrays.asList(apple, banana, carrot, donut),
				"products.txt"
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// ES 7
		System.out.println("\nES7");
		System.out.println(Product.readProductsFrom("products.txt"));
	}
}
