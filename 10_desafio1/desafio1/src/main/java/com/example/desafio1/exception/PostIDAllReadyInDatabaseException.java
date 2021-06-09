package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class PostIDAllReadyInDatabaseException extends ResponseException {

	public PostIDAllReadyInDatabaseException(int id) {
		super("ID: " + id + " ya se encuentra en la base de datos de publicaciones.", HttpStatus.BAD_REQUEST);
	}
}
