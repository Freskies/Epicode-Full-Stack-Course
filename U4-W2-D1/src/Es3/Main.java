package Es3;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

	public static void main (String[] args) {
		OnlineBankAccount account = new OnlineBankAccount(
			"John Doe", 1000, 100
		);

		while (true) {
			Main.askForWithdraw(account);
			account.printBalance();
		}

	}

	private static void askForWithdraw (OnlineBankAccount account) {
		System.out.print("How much do you want to withdraw? ");

		try {
			double money = Double.parseDouble(scanner.nextLine());
			account.withdraw(money);
		} catch (BankException e) {
			logger.error(e.getMessage());
		} catch (NumberFormatException e) {
			logger.error("Invalid input");
		}
	}
}
