package org.u5w2d5.employee;

import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.u5w2d5.response.CreateResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	public EmployeeResponse employeeResponseFromEntity (Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		BeanUtils.copyProperties(employee, employeeResponse);
		return employeeResponse;
	}

	public List<EmployeeResponse> employeeResponsesListFromEntitiesList (@NotNull List<Employee> employees) {
		return employees.stream().map(this::employeeResponseFromEntity).toList();
	}

	public List<EmployeeResponse> findAll () {
		return this.employeeResponsesListFromEntitiesList(this.employeeRepository.findAll());
	}

	public Employee findById (Long id) {
		return this.employeeRepository.findById(id).orElseThrow(() -> new EntityExistsException("Employee not found"));
	}

	public Employee update (Long id, @Valid @NotNull EmployeeRequest employeeRequest) {
		if (this.employeeRepository.existsByUsername(employeeRequest.username()))
			throw new RuntimeException("Username already exists");

		Employee employee = this.findById(id);
		BeanUtils.copyProperties(employeeRequest, employee);
		return this.employeeRepository.save(employee);
	}

	public CreateResponse save (@Valid @NotNull EmployeeRequest employeeRequest) {
		if (this.employeeRepository.existsByUsername(employeeRequest.username()))
			throw new EntityExistsException("Username already exists");

		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRequest, employee);
		this.employeeRepository.save(employee);
		return new CreateResponse(employee.getId());
	}
}
