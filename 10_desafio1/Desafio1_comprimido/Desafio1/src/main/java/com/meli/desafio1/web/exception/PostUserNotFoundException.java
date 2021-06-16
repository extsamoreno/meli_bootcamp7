package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class PostUserNotFoundException extends PostException{
    public PostUserNotFoundException(int user, HttpStatus status) {
        super("The user: " + user + " does not exist.", HttpStatus.BAD_REQUEST);
    }
}
