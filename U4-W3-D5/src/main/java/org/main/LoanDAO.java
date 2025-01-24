package org.main;

import jakarta.persistence.EntityManager;
import org.dao.DAO;
import org.database.Loan;

import java.util.List;

public class LoanDAO extends DAO<Loan, Long> {

	public LoanDAO (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Loan getById (Long id) {
		return super.getById(id, Loan.class);
	}

	@Override
	public void deleteById (Long id) {
		super.deleteById(id, Loan.class);
	}

	@Override
	public List<Loan> findAll () {
		return super.findAll(Loan.class);
	}
}
