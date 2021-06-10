package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistsException extends ResponseException {
    public PostAlreadyExistsException(int postId) {
        super("Cannot generate new post because post ID '" + postId + "' already exists in the system", HttpStatus.BAD_REQUEST);
    }
}
