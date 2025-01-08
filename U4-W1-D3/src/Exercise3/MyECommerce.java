package Exercise3;

public class MyECommerce {
	public static void main(String[] argv) {
		Customer customer = new Customer(
			"1234567890",
			"John",
			"Doe",
			"example@gmail.com",
			"01/01/2021"
		);
		Article[] articles = {
			new Article("123", "Article 1", 10.0, 10),
			new Article("456", "Article 2", 20.0, 20),
			new Article("789", "Article 3", 30.0, 30)
		};

		ShoppingCart shoppingCart = new ShoppingCart(customer, articles);
		System.out.println(shoppingCart);
	}
}
