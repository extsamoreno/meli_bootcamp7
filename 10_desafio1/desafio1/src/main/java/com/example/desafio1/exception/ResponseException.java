package com.example.desafio1.exception;

import com.example.desafio1.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseException extends Exception {
	ErrorDTO error;
	HttpStatus status;

	public ResponseException(String message, HttpStatus status) {
		this.error = new ErrorDTO(message);
		this.status = status;
	}
}
