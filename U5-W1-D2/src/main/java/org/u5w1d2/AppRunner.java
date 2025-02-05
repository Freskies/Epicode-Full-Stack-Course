package org.u5w1d2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
	@Autowired private Drink milk;

	@Override
	public void run (String... args) {
		System.out.println("Drink: " + milk.getName());
	}
}
