package com.example.desafio1.exception;

import com.example.desafio1.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> handleUserIDNotFoundException(UserIDNotFoundException e) {
		return new ResponseEntity<>(e.getError(), e.getStatus());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> handleUserIDAllReadyInFollowsException(UserIDAllReadyInFollowsException e) {
		return new ResponseEntity<>(e.getError(), e.getStatus());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> handleProductIDAllReadyInDatabase(ProductIDAllReadyInDatabaseException e) {
		return new ResponseEntity<>(e.getError(), e.getStatus());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> handlePostIDAllReadyInDatabase(PostIDAllReadyInDatabaseException e) {
		return new ResponseEntity<>(e.getError(), e.getStatus());
	}
}
