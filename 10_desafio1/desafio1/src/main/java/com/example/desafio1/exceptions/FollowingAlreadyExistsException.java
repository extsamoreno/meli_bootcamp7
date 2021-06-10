package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class FollowingAlreadyExistsException extends ResponseException {
    public FollowingAlreadyExistsException() {
        super("User already follows this seller", HttpStatus.BAD_REQUEST);
    }
}
