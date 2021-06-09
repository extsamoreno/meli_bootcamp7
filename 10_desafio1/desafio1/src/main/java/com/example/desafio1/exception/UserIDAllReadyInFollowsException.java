package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserIDAllReadyInFollowsException extends ResponseException {

	public UserIDAllReadyInFollowsException(int id) {
		super("[Error] ID: " + id + " ya se encuentra en la lista de seguidores.", HttpStatus.BAD_REQUEST);
	}
}
