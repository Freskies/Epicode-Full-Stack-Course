package org.u5w2d5.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailResponse {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	// TODO booking list
}
