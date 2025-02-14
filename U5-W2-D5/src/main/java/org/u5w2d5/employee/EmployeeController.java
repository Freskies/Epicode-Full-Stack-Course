package org.u5w2d5.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.u5w2d5.response.CreateResponse;

import java.util.List;

@RestController
@RequestMapping ("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<EmployeeResponse> findAll () {
		return this.employeeService.findAll();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public EmployeeDetailResponse findById (@PathVariable Long id) {
		return this.employeeService.findDetailById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public CreateResponse save (@RequestBody EmployeeRequest employeeRequest) {
		return this.employeeService.save(employeeRequest);
	}

	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public EmployeeDetailResponse update (@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
		return this.employeeService.update(id, employeeRequest);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.employeeService.deleteById(id);
	}
}
