package org.u5w2d5.exceptions;

public record Error(
	String message,
	String details,
	String statusCode
) {
}