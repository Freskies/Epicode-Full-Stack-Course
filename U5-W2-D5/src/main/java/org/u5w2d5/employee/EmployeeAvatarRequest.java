package org.u5w2d5.employee;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record EmployeeAvatarRequest(
	@NotBlank (message = "Avatar URL is mandatory")
	@URL (message = "Avatar URL must be a valid URL")
	String avatarUrl
) {
}
