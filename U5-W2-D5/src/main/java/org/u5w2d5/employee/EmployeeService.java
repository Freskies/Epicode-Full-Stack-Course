package org.u5w2d5.employee;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

	public Employee employeeFromRequest (EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRequest, employee);
		return employee;
	}

	public EmployeeResponse employeeResponseFromEntity (Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		BeanUtils.copyProperties(employee, employeeResponse);
		return employeeResponse;
	}

	public List<EmployeeResponse> employeeResponsesListFromEntitiesList (@NotNull List<Employee> employees) {
		return employees.stream().map(this::employeeResponseFromEntity).toList();
	}

	public EmployeeDetailResponse employeeDetailResponseFromEntity (Employee employee) {
		EmployeeDetailResponse employeeDetailResponse = new EmployeeDetailResponse();
		BeanUtils.copyProperties(employee, employeeDetailResponse);
		return employeeDetailResponse;
	}

	public List<EmployeeResponse> findAll () {
		return this.employeeResponsesListFromEntitiesList(this.employeeRepository.findAll());
	}

	public Employee findById (Long id) {
		return this.employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
	}

	@Transactional
	public EmployeeDetailResponse findDetailById (Long id) {
		if (!this.employeeRepository.existsById(id))
			throw new EntityNotFoundException("Employee not found");

		EmployeeDetailResponse employeeDetailResponse = new EmployeeDetailResponse();
		BeanUtils.copyProperties(this.findById(id), employeeDetailResponse);
		return employeeDetailResponse;
	}

	public EmployeeDetailResponse update (Long id, @Valid @NotNull EmployeeRequest employeeRequest) {
		if (this.employeeRepository.existsByUsername(employeeRequest.username()))
			throw new RuntimeException("Username already exists");

		Employee employee = this.findById(id);
		BeanUtils.copyProperties(employeeRequest, employee);
		this.employeeRepository.save(employee);
		return this.employeeDetailResponseFromEntity(employee);
	}

	public CreateResponse save (@Valid @NotNull EmployeeRequest employeeRequest) {
		if (this.employeeRepository.existsByUsername(employeeRequest.username()))
			throw new EntityExistsException("Username already exists");

		Employee employee = this.employeeFromRequest(employeeRequest);
		this.employeeRepository.save(employee);
		return new CreateResponse(employee.getId());
	}

	public void deleteById (Long id) {
		if (!this.employeeRepository.existsById(id))
			throw new EntityNotFoundException("Employee not found");

		this.employeeRepository.deleteById(id);
	}
}
