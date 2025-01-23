package org.database;

import jakarta.persistence.EntityManager;
import org.dao.DAO;

import java.util.List;

public class EventDAO extends DAO<Event, Long> {

	public EventDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void save (Event event) {
		super.save(event);
	}

	@Override
	public Event getById (Long id) {
		return super.getById(id, Event.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Event.class);
	}

	@Override
	public List<Event> findAll () {
		return super.findAll(Event.class);
	}
}
