package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Magazine;

import java.util.List;

public class MagazineDAO extends DAO<Magazine, Long> {

	public MagazineDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Magazine getById (Long id) {
		return super.getById(id, Magazine.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Magazine.class);
	}

	@Override
	public List<Magazine> findAll () {
		return super.findAll(Magazine.class);
	}
}
