package org.u5w2d5.employee;

import jakarta.validation.constraints.NotBlank;

public record EmployeeRequest(
	@NotBlank(message = "Username is mandatory") String username,
	@NotBlank(message = "First name is mandatory") String firstName,
	@NotBlank(message = "Last name is mandatory") String lastName,
	@NotBlank(message = "Email is mandatory") String email
) {
}
