public class Product {
	public Long id;
	public String name;
	public String category;
	public double price;

	public Product(Long id, String name, String category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	@Override
	public String toString () {
		return "{%s : %.2f€}".formatted(this.name, this.price);
	}
}
