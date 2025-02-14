package org.u5w2d5.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	boolean existsByUsername (String username);
}
