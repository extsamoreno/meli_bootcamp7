package com.example.desafio2.exception;

import com.example.desafio2.dto.ErrorDTO;
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
