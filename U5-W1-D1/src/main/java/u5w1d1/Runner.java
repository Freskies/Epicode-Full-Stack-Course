package u5w1d1;

import menu.Menu;
import menu.MenuConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restourant.Orders.Order;

@Component
public class Runner implements CommandLineRunner {
	@Override
	public void run (String... args) throws Exception {
		Menu menu = new MenuConfig().menu();
		System.out.println(menu);
		System.out.println(new Order().COVER_CHARGE);
	}
}
