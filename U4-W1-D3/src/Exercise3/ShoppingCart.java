package Exercise3;

import java.util.Arrays;

public class ShoppingCart {
	public final Customer owner;
	public final Article[] articles;
	public final double totalPrice;

	public ShoppingCart (Customer owner, Article[] articles) {
		this.owner = owner;
		this.articles = articles;

		double counter = 0;
		for (Article article : articles)
			counter += article.getPrice();
		this.totalPrice = counter;
	}

	@Override
	public String toString () {
		return "ShoppingCart{" +
			"owner=" + this.owner +
			", articles=" + Arrays.toString(this.articles) +
			", totalPrice=" + this.totalPrice +
			'}';
	}
}
