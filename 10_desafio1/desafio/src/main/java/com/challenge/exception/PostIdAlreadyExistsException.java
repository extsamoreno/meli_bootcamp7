package com.challenge.exception;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistsException extends PostException {

    public PostIdAlreadyExistsException() {
        super("There's already a post with that ID", HttpStatus.BAD_REQUEST);
    }
}
