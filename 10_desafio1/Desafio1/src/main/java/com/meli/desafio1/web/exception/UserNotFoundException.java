package com.meli.desafio1.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(String message, HttpStatus status) {
        super("The id: " + message + " does not match User.", HttpStatus.BAD_REQUEST);
    }
}
