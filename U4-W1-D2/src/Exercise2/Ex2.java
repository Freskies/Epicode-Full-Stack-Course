package Exercise2;

import java.util.Scanner;

public class Ex2 {
	public static void start () {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Insert a number: ");
			int number = Integer.parseInt(scanner.nextLine());
			System.out.println(getResult(number));
			scanner.close();
		} catch (NumberFormatException e) {
			System.out.println("The input is not a number!");
		}
	}

	private static String getResult (int number) {
		return switch (number) {
			case 0 -> "zero";
			case 1 -> "one";
			case 2 -> "two";
			case 3 -> "three";
			default -> "The number is not between 0 and 3!";
		};
	}
}
