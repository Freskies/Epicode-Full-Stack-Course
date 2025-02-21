package org.exceptions;

public record Error(
	String message,
	String details,
	String status
) {
}
