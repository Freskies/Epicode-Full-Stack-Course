package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Genre;

import java.util.List;

public class GenreDAO extends DAO<Genre, Long> {

	public GenreDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Genre getById (Long id) {
		return super.getById(id, Genre.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Genre.class);
	}

	@Override
	public List<Genre> findAll () {
		return super.findAll(Genre.class);
	}
}
