package Shop;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
	private final Long id;
	private String name;
	private String category;
	private double price;

	public Product(String name, String category, double price) {
		this.id = new Random().nextLong();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId () {
		return this.id;
	}

	public String getName () {
		return this.name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getCategory () {
		return this.category;
	}

	public void setCategory (String category) {
		this.category = category;
	}

	public double getPrice () {
		return this.price;
	}

	public void setPrice (double price) {
		this.price = price;
	}

	public static Product compareProductByAscendingPrice (Product p1, Product p2) {
		if (p1 == null && p2 == null) return null;
		if (p1 == null) return p2;
		if (p2 == null) return p1;
		return p1.getPrice() > p2.getPrice() ? p1 : p2;
	}

	public static Product getMostExpensiveProductOf (List<Product> products) {
		return products.stream().reduce(
			null,
			Product::compareProductByAscendingPrice,
			Product::compareProductByAscendingPrice
		);
	}

	public static Map<String, Double> getPricesPerCategory (List<Product> products) {
		return products.stream().collect(
			Collectors.toMap(
				Product::getCategory,
				Product::getPrice,
				Double::sum
			)
		);
	}

	public static void saveProductsInFile(List<Product> products, String path) throws IOException {
		try (FileWriter writer = new FileWriter(path)) {
			List<String> stringsProduct = new LinkedList<>();
			for (Product product : products)
				stringsProduct.add(product.transformToSavableString());
			writer.write(String.join("#", stringsProduct));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<Product> readProductsFrom(String path) {
		try (Scanner reader = new Scanner(new File(path))) {
			String stringProducts = reader.nextLine();
			return Arrays.stream(stringProducts.split("#")).map(
				Product::getProductFromString
			).toList();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean equals (Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getName(), getCategory(), getPrice());
	}

	@Override
	public String toString () {
		return "Product{%s: %.2f€}".formatted(this.getName(), this.getPrice());
	}

	public String transformToSavableString () {
		return "%s@%s@%.2f".formatted(this.getName(), this.getCategory(), this.getPrice());
	}

	public static Product getProductFromString (String product) {
		List<String> props = Arrays.asList(product.split("@"));
		return new Product(
			props.get(0),
			props.get(1),
			Double.parseDouble(props.get(2))
		);
	}
}
