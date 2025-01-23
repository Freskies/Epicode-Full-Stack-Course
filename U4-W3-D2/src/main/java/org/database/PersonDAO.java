package org.database;

import jakarta.persistence.EntityManager;
import org.dao.DAO;

import java.util.List;

public class PersonDAO extends DAO<Person, Long> {

	public PersonDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void save (Person person) {
		super.save(person);
	}

	@Override
	public Person getById (Long id) {
		return super.getById(id, Person.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Person.class);
	}

	@Override
	public List<Person> findAll () {
		return super.findAll(Person.class);
	}

}
