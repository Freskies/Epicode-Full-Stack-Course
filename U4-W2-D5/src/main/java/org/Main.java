package org;

import Library.*;

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
	};

	public static Scanner scanner = new Scanner(System.in);

	public static String scan () {
		return Main.scanner.nextLine();
	}

	public static void main (String[] args) {
		Archive archive = new Archive();
		Arrays.stream(Main.fooPublication).forEach(archive::addPublication);
		archive.printStatistic();

		Main.menu();
	}

	public static void menu () {
		System.out.print("""
			1. See archive
			2. Add publication
			3. Modify publication
			0. Exit
			""");
	}
}
