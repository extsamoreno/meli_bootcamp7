package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistsException extends PostException{
    public PostAlreadyExistsException(int post_id,  HttpStatus status) {
        super("The post " + post_id + " already exists, try with another id.", HttpStatus.BAD_REQUEST);
    }
}
