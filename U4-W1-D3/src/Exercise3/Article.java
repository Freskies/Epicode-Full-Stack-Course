package Exercise3;

public class Article {
	private String articleCode;
	private String description;
	private double price;
	private int piecesAvailable;

	public Article (String articleCode, String description, double price, int piecesAvailable) {
		this.articleCode = articleCode;
		this.description = description;
		this.price = price;
		this.piecesAvailable = piecesAvailable;
	}

	public double getPrice () {
		return price;
	}

	@Override
	public String toString () {
		return "Article{" +
			"articleCode='" + articleCode + '\'' +
			", description='" + description + '\'' +
			", price=" + price +
			", piecesAvailable=" + piecesAvailable +
			'}';
	}
}
