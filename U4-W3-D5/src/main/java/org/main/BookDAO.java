package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Book;

import java.util.List;

public class BookDAO extends DAO<Book, Long> {

	public BookDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Book getById (Long id) {
		return super.getById(id, Book.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Book.class);
	}

	@Override
	public List<Book> findAll () {
		return super.findAll(Book.class);
	}

	public List<Book> findByAuthor (String author) {
		entityManager.getTransaction().begin();
		List<Book> book = this.entityManager.createQuery(
			"SELECT b FROM Book b WHERE b.author.name = :author", Book.class
		).setParameter("author", author).getResultList();
		entityManager.getTransaction().commit();
		return book;
	}
}
