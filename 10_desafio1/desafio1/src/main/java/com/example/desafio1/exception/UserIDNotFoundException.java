package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserIDNotFoundException extends ResponseException {
	public UserIDNotFoundException(int id) {
		super("[Error] ID: " + id + " de usuario no encontrado.", HttpStatus.BAD_REQUEST);
	}
}
