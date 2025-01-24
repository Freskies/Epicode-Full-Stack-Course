package org.main;

import jakarta.persistence.EntityManager;
import org.dao.EntityManagerUtil;
import org.database.Book;
import org.database.Magazine;
import org.database.Periodicity;
import org.jetbrains.annotations.NotNull;

public class Main {
	public static void main (String[] args) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			GenreDAO genreDAO = new GenreDAO(entityManager);
			AuthorDAO authorDAO = new AuthorDAO(entityManager);
			BookDAO bookDAO = new BookDAO(entityManager);
			MagazineDAO magazineDAO = new MagazineDAO(entityManager);
			PublicationDAO publicationDAO = new PublicationDAO(entityManager);

			Main.task1(bookDAO, authorDAO, genreDAO);
			Main.task2(bookDAO);
			Main.task3(publicationDAO);
			Main.task4(publicationDAO);
			Main.task5(bookDAO);
			Main.task6(publicationDAO);
			Main.task7(publicationDAO);
			Main.task8(publicationDAO);
		} finally {
			EntityManagerUtil.closeEntityManagerFactory();
		}
	}


	/**
	 * Add element to the database
	 */
	public static void task1 (
		@NotNull BookDAO bookDAO,
		@NotNull AuthorDAO authorDAO,
		@NotNull GenreDAO genreDAO
	) {
		System.out.println("TASK 1");
		Book book = new Book(
			"The Lord of the Rings",
			1954,
			1176,
			authorDAO.getById(1L),
			genreDAO.getById(1L)
		);
		// bookDAO.save(book);
		bookDAO.findAll().forEach(System.out::println);
	}

	/**
	 * Delete element from the database
	 */
	public static void task2 (BookDAO bookDAO) {
		System.out.println("TASK 2");
		// bookDAO.deleteById(1L);
	}

	/**
	 * Search publication for isbn
	 */
	public static void task3 (PublicationDAO publicationDAO) {
		System.out.println("TASK 3");
		publicationDAO.getById(1L);
	}

	/**
	 * Search publication for publicationYear
	 */
	public static void task4 (PublicationDAO publicationDAO) {
		System.out.println("TASK 4");
		publicationDAO.findByYear(1954).forEach(System.out::println);
	}

	/**
	 * Search book for author
	 */
	public static void task5 (BookDAO bookDAO) {
		System.out.println("TASK 5");
		bookDAO.findByAuthor("Isaac Asimov").forEach(System.out::println);
	}

	/**
	 * Search book for title (o part of title)
	 */
	public static void task6 (PublicationDAO publicationDAO) {
		System.out.println("TASK 6");
		publicationDAO.findByTitle("The").forEach(System.out::println);
	}

	/**
	 * Search publication loaned (not returned) for a user
	 */
	public static void task7 (PublicationDAO publicationDAO) {
		System.out.println("TASK 7");
		publicationDAO.findLoanedBy(1L).forEach(System.out::println);
	}

	/**
	 * Search all publications loaned (not returned) and expired
	 */
	public static void task8 (PublicationDAO publicationDAO) {
		System.out.println("TASK 8");
		publicationDAO.findLoanedAndExpired().forEach(System.out::println);
		System.out.println("TASK 8 (MY EXTRA) - Late loans");
		publicationDAO.findLateLoans().forEach(System.out::println);
	}
}
