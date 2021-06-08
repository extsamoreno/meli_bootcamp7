package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(Integer userId) {
        super("ID: " + userId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
