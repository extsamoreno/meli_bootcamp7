package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class IDAllReadyPresentException extends ResponseException {

	public IDAllReadyPresentException(int id) {
		super("[Error] ID: " + id + " ya se encuentra presente.", HttpStatus.BAD_REQUEST);
	}
}
