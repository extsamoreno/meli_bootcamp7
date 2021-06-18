package com.example.desafio2.exception;

import org.springframework.http.HttpStatus;

public class NameNotFoundException extends ResponseException {
	public NameNotFoundException(String name) {
		super("[Error] Nombre: " + name + " no encontrado.", HttpStatus.BAD_REQUEST);
	}
}