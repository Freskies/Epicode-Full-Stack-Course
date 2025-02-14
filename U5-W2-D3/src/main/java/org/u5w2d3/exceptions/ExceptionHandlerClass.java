package org.u5w2d3.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler (value = EntityNotFoundException.class)
	protected ResponseEntity<Error> entityNotFound (@NotNull EntityNotFoundException e) {
		Error error = new Error("Entity not found", e.getMessage(), "404");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler (value = Exception.class)
	protected ResponseEntity<Error> entityAlreadyExists (@NotNull Exception e) {
		Error error = new Error("Entity already exists", e.getMessage(), "409");
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

}
