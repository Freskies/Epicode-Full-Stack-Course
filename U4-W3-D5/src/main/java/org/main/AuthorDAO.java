package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Author;

import java.util.List;

public class AuthorDAO extends DAO<Author, Long> {

	public AuthorDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Author getById (Long id) {
		return super.getById(id, Author.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Author.class);
	}

	@Override
	public List<Author> findAll () {
		return super.findAll(Author.class);
	}
}
