package org.database;

import jakarta.persistence.EntityManager;
import org.dao.DAO;

import java.util.List;

public class ParticipantDAO extends DAO<Participant, Long> {

	public ParticipantDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void save (Participant participant) {
		super.save(participant);
	}

	@Override
	public Participant getById (Long id) {
		return super.getById(id, Participant.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Participant.class);
	}

	@Override
	public List<Participant> findAll () {
		return super.findAll(Participant.class);
	}
}
