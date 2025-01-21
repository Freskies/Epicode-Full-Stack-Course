package org.events;

import jakarta.persistence.EntityManager;

public class EventDAO {

	public static void saveEvent (Event event) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			entityManager.getTransaction().begin();
			entityManager.persist(event);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
		EntityManagerUtil.closeEntityManagerFactory();
	}

	public static Event getEvent (Long id) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			entityManager.getTransaction().begin();
			Event event = entityManager.find(Event.class, id);
			entityManager.getTransaction().commit();
			return event;
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			return null;
		}
	}

	public static void deleteEvent (Long id) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			entityManager.getTransaction().begin();
			Event event = entityManager.find(Event.class, id);
			entityManager.remove(event);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
		EntityManagerUtil.closeEntityManagerFactory();
	}

	public static void deleteEvent (Event event) {
		try (EntityManager entityManager = EntityManagerUtil.getEntityManager()) {
			entityManager.getTransaction().begin();
			entityManager.remove(event);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
		EntityManagerUtil.closeEntityManagerFactory();
	}
}
