package Shop;

import java.util.Objects;
import java.util.Random;

public class Customer {
	private final Long id = new Random().nextLong();
	private String name;
	private int tier;

	public Customer(String name) {
		this.name = name;
		this.tier = 1;
	}

	public Customer(String name, int tier) {
		this.name = name;
		this.tier = tier;
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

	public int getTier () {
		return this.tier;
	}

	public void setTier (int tier) {
		this.tier = tier;
	}

	@Override
	public boolean equals (Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return getTier() == customer.getTier() && Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getName(), getTier());
	}

	@Override
	public String toString () {
		return "Customer{%s}".formatted(this.getName());
	}
}
