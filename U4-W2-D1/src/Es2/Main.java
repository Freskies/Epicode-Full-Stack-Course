package Es2;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

	public static void main (String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("KM: ");
			double km = Double.parseDouble(scanner.nextLine());
			System.out.print("GAS: ");
			double gas = Double.parseDouble(scanner.nextLine());
			System.out.printf("%.2f km/l", new Car(km, gas).calc());
		} catch (NumberFormatException _) {
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		}
	}
}
