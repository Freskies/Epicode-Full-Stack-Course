package org.events;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
	 private static final EntityManagerFactory entityManagerFactory =
		 Persistence.createEntityManagerFactory("eventManagementPU");

	 public static EntityManager getEntityManager () {
		 return entityManagerFactory.createEntityManager();
	 }

	 public static void closeEntityManagerFactory() {
		 entityManagerFactory.close();
	 }
}
