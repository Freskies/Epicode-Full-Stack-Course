package org.database;

import jakarta.persistence.EntityManager;
import org.dao.DAO;

import java.util.List;

public class LocationDAO extends DAO<Location, Long> {

	public LocationDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void save (Location location) {
		super.save(location);
	}

	@Override
	public Location getById (Long id) {
		return super.getById(id, Location.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Location.class);
	}

	@Override
	public List<Location> findAll () {
		return super.findAll(Location.class);
	}

}
