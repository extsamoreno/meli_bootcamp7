package com.meli.desafio.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ExceptionModel{
    public UserNotFoundException(Integer id) {
        super("the user with the id " + id + " is not found", HttpStatus.BAD_REQUEST);
    }

    public UserNotFoundException(String username) {
        super("the user with the username " + username + " is not found", HttpStatus.BAD_REQUEST);
    }
}