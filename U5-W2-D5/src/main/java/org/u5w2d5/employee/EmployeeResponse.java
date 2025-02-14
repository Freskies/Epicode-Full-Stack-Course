package org.u5w2d5.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
}
