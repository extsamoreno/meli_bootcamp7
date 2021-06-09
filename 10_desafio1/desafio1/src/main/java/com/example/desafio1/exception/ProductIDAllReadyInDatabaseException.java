package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class ProductIDAllReadyInDatabaseException extends ResponseException {

	public ProductIDAllReadyInDatabaseException(int id) {
		super("[Error] ID: " + id + " ya se encuentra en la base de datos de productos.", HttpStatus.BAD_REQUEST);
	}
}
