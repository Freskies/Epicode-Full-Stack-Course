package Exercise4;

import java.util.Scanner;

public class Ex4 {
	public static void start () {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Insert a number: ");
			int number = Integer.parseInt(scanner.nextLine());
			if (number < 0)
				System.out.println("Number must be greater than 0!");
			else {
				for (int i = number; i > 0; i--)
					System.out.print(i + " ");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number!");
		}
	}
}
