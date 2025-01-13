package Es1;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);
	private static final Scanner scanner = new Scanner(System.in);

	public static void main (String[] args) {
		int[][] arrays = new int[5][10];

		for (int i = 0; i < arrays.length; i++)
			for (int j = 0; j < arrays[0].length; j++)
				arrays[i][j] = (int) (Math.random() * 10) + 1;

		logger.debug(Arrays.deepToString(arrays));

		while (Main.askUser(arrays));
	}

	private static boolean askUser (int[][] arrays) {
		try {
			System.out.print("Array: ");
			int inputArray = Integer.parseInt(scanner.nextLine());
			System.out.print("Position: ");
			int inputPosition = Integer.parseInt(scanner.nextLine());
			System.out.print("New value: ");
			int inputNewValue = Integer.parseInt(scanner.nextLine());
			if (inputNewValue == 0) return false;
			arrays[inputArray][inputPosition] = inputNewValue;
			System.out.println(Arrays.deepToString(arrays));
		} catch (ArrayIndexOutOfBoundsException _) {
			System.out.println("invalid input");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
}
