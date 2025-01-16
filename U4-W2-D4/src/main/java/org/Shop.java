package org;

import java.util.*;
import java.util.stream.Collectors;

import Shop.Order;
import Shop.Customer;

public class Shop extends HashSet<Order> {
	public Shop () {
		super();
	}

	public Shop (Order... orders) {
		super(List.of(orders));
	}

	public Shop (Collection<? extends Order> c) {
		super(c);
	}

	public List<Order> getAllOrderOf (Customer customer) {
		return this.stream()
			.filter(order -> order.getCustomer().equals(customer))
			.toList();
	}

	public HashMap<Customer, List<Order>> getAllOrderGroupedByCustomers () {
		return (HashMap<Customer, List<Order>>) this.stream()
			.collect(Collectors.toMap(
				order -> order.getCustomer(),
				order -> Arrays.stream(new Order[] {order}).toList(),
				(order1, order2) -> {
					List<Order> orders = new ArrayList<>(order1);
					orders.addAll(order2);
					return orders;
				}
			));
	}

	public HashMap<Customer, Double> getTotalPerCustomer () {
		return (HashMap<Customer, Double>) this.stream()
			.collect(Collectors.toMap(
				order -> order.getCustomer(),
				order -> order.getTotal(),
				Double::sum
			));
	}

	public double getAverageTotal () {
		return this.stream().collect(
			Collectors.averagingDouble(
				order -> order.getTotal()
			)
		);
	}
}
