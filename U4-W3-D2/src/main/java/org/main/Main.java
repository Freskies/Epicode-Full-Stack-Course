package org.main;

import jakarta.persistence.EntityManager;
import org.dao.EntityManagerUtil;
import org.database.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Main {
	public static void main (String[] args) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			PersonDAO personDAO = new PersonDAO(entityManager);
			LocationDAO locationDAO = new LocationDAO(entityManager);
			EventDAO eventDAO = new EventDAO(entityManager);
			ParticipantDAO participantDAO = new ParticipantDAO(entityManager);

			Main.task1(locationDAO);
			Main.task2(eventDAO, locationDAO);
			Main.task3(personDAO);
			Main.task4(participantDAO, personDAO, eventDAO);

		} finally {
			EntityManagerUtil.closeEntityManagerFactory();
		}
	}

	public static void task1 (@NotNull LocationDAO locationDAO) {
		Location location = new Location("Ravenna", "Via Chicken 69");
		// locationDAO.save(location);
		locationDAO.findAll().forEach(System.out::println);
	}

	public static void task2 (@NotNull EventDAO eventDAO, @NotNull LocationDAO locationDAO) {
		Location location = locationDAO.getById(402L);
		System.out.println(location);

		Event event = new Event(
			"Cake contest",
			LocalDate.of(2021, 12, 31),
			"Boss cake contest REAL TIME (32)",
			EventType.PUBLIC,
			10,
			location
		);
		System.out.println(event);

		//eventDAO.save(event);
		eventDAO.findAll().forEach(System.out::println);
	}

	public static void task3 (@NotNull PersonDAO personDAO) {
		Person person = new Person(
			"Giuliano",
			"Torrisi",
			"ciola@giuliano.com",
			LocalDate.of(1999, 2, 27),
			Sex.M
		);
		// personDAO.save(person);
		personDAO.findAll().forEach(System.out::println);
	}

	public static void task4 (
		@NotNull ParticipantDAO participantDAO,
		@NotNull PersonDAO personDAO,
		@NotNull EventDAO eventDAO
	) {
		Person person = personDAO.getById(3L);
		Event event = eventDAO.getById(6L);
		Participant participant = new Participant(event, person, State.PENDING);
		participantDAO.save(participant);
		participantDAO.findAll().forEach(System.out::println);
	}
}
