package Es1;

import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Main.askNumber(scanner);
		LinkedList<String> words = new LinkedList<>();
		for (int i = 0; i < number; i++)
			words.add(Main.askWord(scanner));

		// print duplicates
		HashSet<String> unique_words = new HashSet<>(words);
		HashSet<String> duplicates = new HashSet<>();

		for (String word : unique_words)
			if (Collections.frequency(words, word) > 1)
				duplicates.add(word);

		// print duplicates
		System.out.println(duplicates);
		// print n unique
		System.out.println(unique_words.size());
		// print unique
		System.out.println(unique_words);
	}

	private static int askNumber (Scanner scanner) {
		try {
			System.out.println("Insert a number: ");
			int number = Integer.parseInt(scanner.nextLine());
			return number > 0 ? number : Main.askNumber(scanner);
		} catch (NumberFormatException e) {
			return Main.askNumber(scanner);
		}
	}

	private static String askWord (Scanner scanner) {
		System.out.println("Insert a word: ");
		String word = scanner.nextLine();
		return word.isEmpty() ? Main.askWord(scanner) : word;
	}
}
