package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.User;

import java.util.List;

public class UserDAO extends DAO<User, Long> {

	public UserDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public User getById (Long id) {
		return super.getById(id, User.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, User.class);
	}

	@Override
	public List<User> findAll () {
		return super.findAll(User.class);
	}
}
