package org;

import Library.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final Publication[] fooPublication = new Publication[] {
		new Book("abc123", "The Lord of the Rings", "1954", 1178, "J.R.R. Tolkien", "Fantasy"),
		new Book("def456", "The Hobbit", "1937", 310, "J.R.R. Tolkien", "Fantasy"),
		new Magazine("ghi789", "National Geographic", "1888", 200, Periodicity.MONTHLY),
		new Magazine("jkl012", "Time", "1923", 100, Periodicity.WEEKLY),
		new Book("mno345", "1984", "1949", 328, "George Orwell", "Dystopian"),
		new Book("pqr678", "To Kill a Mockingbird", "1960", 281, "Harper Lee", "Fiction"),
		new Book("stu901", "Pride and Prejudice", "1813", 279, "Jane Austen", "Romance"),
		new Book("vwx234", "The Great Gatsby", "1925", 180, "F. Scott Fitzgerald", "Tragedy"),
		new Book("yzb567", "Moby Dick", "1851", 635, "Herman Melville", "Adventure"),
		new Magazine("cde890", "Scientific American", "1845", 100, Periodicity.MONTHLY),
		new Magazine("fgh123", "The Economist", "1843", 80, Periodicity.WEEKLY),
		new Magazine("ijk456", "Vogue", "1892", 150, Periodicity.MONTHLY),
		new Magazine("lmn789", "Forbes", "1917", 120, Periodicity.SEMIANNUAL),
		new Magazine("opq012", "People", "1974", 90, Periodicity.WEEKLY),
		new Book("rst345", "The Fellowship of the Ring", "1954", 423, "J.R.R. Tolkien", "Fantasy")
	};

	public static Scanner scanner = new Scanner(System.in);

	public static String scan () {
		return Main.scanner.nextLine();
	}

	public static void main (String[] args) {
		Archive archive = new Archive();
		Arrays.stream(Main.fooPublication).forEach(archive::addPublication);

		Main.menu(archive);
	}

	// MAIN MENU

	public static void menu (Archive archive) {
		System.out.print("""
			####################
			1. Info
			2. Add publication
			3. Modify publication
			0. Exit
			->\s""");

		switch (Main.scan()) {
			case "1" -> Main.infoMenu(archive);
			case "2" -> Main.addPublicationMenu(archive);
			case "3" -> Main.ModifyPublicationMenu(archive);
			case "0" -> System.exit(0);
			default -> {
				System.out.println("Invalid input");
				Main.menu(archive);
			}
		}
	}

	// INFO MENU

	@SuppressWarnings ("InfiniteRecursion")
	public static void infoMenu (Archive archive) {
		System.out.print("""
			-------------------
			1. See all publications
			2. See all books
			3. See all magazines
			4. See all publication of a year
			5. See all books of an author
			6. See all books of a genre
			7. See all magazines of a periodicity
			8. Publication with the most pages
			9. Archive statistics
			0. Back
			->\s""");

		switch (Main.scan()) {
			case "1" -> Main.seeAllPublications(archive);
			case "2" -> Main.seeAllBooks(archive);
			case "3" -> Main.seeAllMagazines(archive);
			case "4" -> Main.seeAllPublicationOfYear(archive);
			case "5" -> Main.seeAllBooksOfAuthor(archive);
			case "6" -> Main.seeAllBooksOfGenre(archive);
			case "7" -> Main.seeAllMagazinesOfPeriodicity(archive);
			case "8" -> Main.seePublicationWithMostPages(archive);
			case "9" -> archive.printStatistic();
			case "0" -> Main.menu(archive);
			case null, default -> System.out.println("Invalid input");
		}

		Main.infoMenu(archive);
	}

	public static void seeAllPublications (@NotNull Archive archive) {
		archive.getAllPublication().forEach(System.out::println);
	}

	public static void seeAllBooks (@NotNull Archive archive) {
		archive.getAllBooks().forEach(System.out::println);
	}

	public static void seeAllMagazines (@NotNull Archive archive) {
		archive.getAllMagazine().forEach(System.out::println);
	}

	public static void seeAllPublicationOfYear (@NotNull Archive archive) {
		System.out.print("Enter year: ");
		String year = Main.scan();
		archive.getPublicationsOfYear(year).forEach(System.out::println);
	}

	public static void seeAllBooksOfAuthor (@NotNull Archive archive) {
		System.out.print("Enter author: ");
		String author = Main.scan();
		archive.getBooksOfAuthor(author).forEach(System.out::println);
	}

	public static void seeAllBooksOfGenre (@NotNull Archive archive) {
		System.out.print("Enter genre: ");
		String genre = Main.scan();
		archive.getBooksOfGenre(genre).forEach(System.out::println);
	}

	public static void seeAllMagazinesOfPeriodicity (@NotNull Archive archive) {
		System.out.print("Enter periodicity: ");
		try {
			Periodicity periodicity = Periodicity.valueOf(Main.scan().toUpperCase());
			archive.getMagazinesOfPeriodicity(periodicity).forEach(System.out::println);
		} catch (IllegalArgumentException _) {
		}
	}

	public static void seePublicationWithMostPages (@NotNull Archive archive) {
		System.out.println(archive.getLongestPublication());
	}

	// ADD PUBLICATION MENU

	@SuppressWarnings ("InfiniteRecursion")
	public static void addPublicationMenu (Archive archive) {
		System.out.print("""
			-------------------
			1. Add book
			2. Add magazine
			0. Back
			->\s""");

		switch (Main.scan()) {
			case "1" -> Main.addBookMenu(archive);
			case "2" -> Main.addMagazineMenu(archive);
			case "0" -> Main.menu(archive);
			default -> {
				System.out.println("Invalid input");
				Main.addPublicationMenu(archive);
			}
		}

		Main.addPublicationMenu(archive);
	}

	public static void addBookMenu (@NotNull Archive archive) {
		try {
			boolean added = archive.addPublication(new Book(
				Main.askISBN(),
				Main.askTitle(),
				Main.askPublicationYear(),
				Main.askPageCount(),
				Main.askAuthor(),
				Main.askGenre()
			));
			if (!added) {
				System.out.println("Book already exists");
				Main.addBookMenu(archive);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\tInvalid book: " + e.getMessage());
			Main.addBookMenu(archive);
		}
	}

	public static void addMagazineMenu (@NotNull Archive archive) {
		try {
			archive.addPublication(new Magazine(
				Main.askISBN(),
				Main.askTitle(),
				Main.askPublicationYear(),
				Main.askPageCount(),
				Periodicity.valueOf(Main.askPeriodicity().toUpperCase())
			));
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid input: " + e.getMessage());
			Main.addMagazineMenu(archive);
		}
	}

	// MODIFY PUBLICATION MENU

	public static void ModifyPublicationMenu (@NotNull Archive archive) {
		try {
			String isbn = Main.askISBN();
			Publication publication = archive.getPublication(isbn);

			switch (publication) {
				case Book _ -> Main.modifyBookMenu(archive, isbn);
				case Magazine _ -> Main.modifyMagazineMenu(archive, isbn);
				case null, default -> {
					System.out.println("Publication not found");
					Main.menu(archive);
				}
			}
		} catch (IllegalISBNProvided e) {
			System.out.println("\tInvalid ISBN: " + e.getMessage());
			Main.menu(archive);
		}
	}

	@SuppressWarnings ("InfiniteRecursion")
	public static void modifyBookMenu (@NotNull Archive archive, String isbn) {
		System.out.print("""
			-------------------
			1. Modify title
			2. Modify publication year
			3. Modify page count
			4. Modify author
			5. Modify genre
			0. Back
			->\s""");

		try {
			switch (Main.scan()) {
				case "1" -> archive.modifyTitle(isbn, Main.askTitle());
				case "2" -> archive.modifyPublicationYear(isbn, Main.askPublicationYear());
				case "3" -> archive.modifyPageCount(isbn, Main.askPageCount());
				case "4" -> archive.modifyAuthor(isbn, Main.askAuthor());
				case "5" -> archive.modifyGenre(isbn, Main.askGenre());
				case "0" -> Main.menu(archive);
				default -> {
					System.out.println("Invalid input");
					Main.modifyBookMenu(archive, isbn);
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\tInvalid book: " + e.getMessage());
		} finally {
			Main.modifyBookMenu(archive, isbn);
		}
	}

	@SuppressWarnings ("InfiniteRecursion")
	public static void modifyMagazineMenu (@NotNull Archive archive, String isbn) {
		System.out.print("""
			-------------------
			1. Modify title
			2. Modify publication year
			3. Modify page count
			4. Modify periodicity
			0. Back
			->\s""");

		try {
			switch (Main.scan()) {
				case "1" -> archive.modifyTitle(isbn, Main.askTitle());
				case "2" -> archive.modifyPublicationYear(isbn, Main.askPublicationYear());
				case "3" -> archive.modifyPageCount(isbn, Main.askPageCount());
				case "4" -> archive.modifyPeriodicity(isbn, Periodicity.valueOf(Main.askPeriodicity().toUpperCase()));
				case "0" -> Main.menu(archive);
				default -> {
					System.out.println("Invalid input");
					Main.modifyMagazineMenu(archive, isbn);
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\tInvalid magazine: " + e.getMessage());
		} finally {
			Main.modifyMagazineMenu(archive, isbn);
		}
	}

	// ASK INPUTS

	public static @NotNull String askISBN () {
		System.out.print("\tEnter ISBN (at least 6 characters): ");
		String input = Main.scan();
		if (input.length() < 6) {
			System.out.println("\tInvalid ISBN");
			return Main.askISBN();
		}
		return input;
	}

	public static @NotNull String askTitle () {
		System.out.print("\tEnter title: ");
		String input = Main.scan();
		if (input.isBlank()) {
			System.out.println("\tInvalid title");
			return Main.askTitle();
		}
		return input;
	}

	public static @NotNull String askPublicationYear () {
		System.out.print("\tEnter publication year: ");
		String input = Main.scan();
		if (!input.matches("-?\\d+")) {
			System.out.println("\tInvalid publication year");
			return Main.askPublicationYear();
		}
		return input;
	}

	public static int askPageCount () {
		System.out.print("\tEnter page count: ");
		String input = Main.scan();
		if (!input.matches("\\d+")) {
			System.out.println("\tInvalid page count");
			return Main.askPageCount();
		}
		return Integer.parseInt(input);
	}

	public static @NotNull String askAuthor () {
		System.out.print("\tEnter author: ");
		String input = Main.scan();
		if (input.isBlank()) {
			System.out.println("\tInvalid author");
			return Main.askAuthor();
		}
		return input;
	}

	public static @NotNull String askGenre () {
		System.out.print("\tEnter genre: ");
		String input = Main.scan();
		if (input.isBlank()) {
			System.out.println("\tInvalid genre");
			return Main.askGenre();
		}
		return input;
	}

	public static @NotNull String askPeriodicity () {
		System.out.print("\tEnter periodicity (weekly, monthly, semiannual): ");
		String input = Main.scan();
		if (!input.matches("weekly|monthly|semiannual")) {
			System.out.println("\tInvalid periodicity");
			return Main.askPeriodicity();
		}
		return input;
	}
}
