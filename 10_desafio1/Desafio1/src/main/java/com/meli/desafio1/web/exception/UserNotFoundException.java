package com.meli.desafio1.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(int message, HttpStatus status) {
        super("The user: " + message + " does not exist.", HttpStatus.BAD_REQUEST);
    }
}
