package Exercise3;

import java.util.Objects;
import java.util.Scanner;

public class Ex3 {
	public static void start () {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Write something (:q to break): ");
			String input = scanner.nextLine();
			if (Objects.equals(input, ":q")) break;

			for (int i = 0; i < input.length(); i++)
				System.out.print(input.charAt(i) + (i == input.length() - 1 ? "" : ","));

			System.out.println();
		}

		scanner.close();
	}
}
