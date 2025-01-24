package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Publication;

import java.util.List;

public class PublicationDAO extends DAO<Publication, Long> {

	public PublicationDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Publication getById (Long id) {
		return super.getById(id, Publication.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Publication.class);
	}

	@Override
	public List<Publication> findAll () {
		return super.findAll(Publication.class);
	}

	public List<Publication> findByYear (int year) {
		entityManager.getTransaction().begin();
		List<Publication> publication = this.entityManager.createQuery(
			"SELECT p FROM Publication p WHERE p.yearOfPublication = :year", Publication.class
		).setParameter("year", year).getResultList();
		entityManager.getTransaction().commit();
		return publication;
	}

	public List<Publication> findByTitle (String title) {
		entityManager.getTransaction().begin();
		List<Publication> publication = this.entityManager.createQuery(
			"SELECT p FROM Publication p WHERE p.title LIKE CONCAT('%', :title, '%')",
			Publication.class
		).setParameter("title", title).getResultList();
		entityManager.getTransaction().commit();
		return publication;
	}

	public List<Publication> findLoanedBy (Long userId) {
		entityManager.getTransaction().begin();
		List<Publication> publication = this.entityManager.createQuery(
			"""
				SELECT p
				FROM Publication p, Loan l
				WHERE l.user.id = :userId
				AND l.isbn.id = p.id
				AND l.effectiveReturnDate IS NULL
				""",
			Publication.class
		).setParameter("userId", userId).getResultList();
		entityManager.getTransaction().commit();
		return publication;
	}

	public List<Publication> findLoanedAndExpired () {
		entityManager.getTransaction().begin();
		List<Publication> publication = this.entityManager.createQuery(
			"""
				SELECT p
				FROM Publication p, Loan l
				WHERE l.isbn.id = p.id
				AND l.exceptedReturnDate < CURRENT DATE
				AND l.effectiveReturnDate IS NULL
				""",
			Publication.class
		).getResultList();
		entityManager.getTransaction().commit();
		return publication;
	}

	public List<Publication> findLateLoans () {
		entityManager.getTransaction().begin();
		List<Publication> publication = this.entityManager.createQuery(
			"""
				SELECT p
				FROM Publication p, Loan l
				WHERE l.isbn.id = p.id
				AND l.exceptedReturnDate < CURRENT DATE
				AND (
					l.effectiveReturnDate IS NULL
					OR l.effectiveReturnDate > l.exceptedReturnDate
					)
				""",
			Publication.class
		).getResultList();
		entityManager.getTransaction().commit();
		return publication;
	}
}
