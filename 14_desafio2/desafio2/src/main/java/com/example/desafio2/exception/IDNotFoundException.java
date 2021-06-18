package com.example.desafio2.exception;

import org.springframework.http.HttpStatus;

public class IDNotFoundException extends ResponseException {
	public IDNotFoundException(int id) {
		super("[Error] ID: " + id + " no encontrado.", HttpStatus.BAD_REQUEST);
	}
}