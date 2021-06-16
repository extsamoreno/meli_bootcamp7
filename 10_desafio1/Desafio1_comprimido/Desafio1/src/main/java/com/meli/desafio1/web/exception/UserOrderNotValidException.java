package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class UserOrderNotValidException extends UserException{
    public UserOrderNotValidException(String message, HttpStatus status) {
        super("The order parameter " + message + " is invalid.", HttpStatus.BAD_REQUEST);
    }
}
