package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class InvalidPostValueException extends PostException{
    public InvalidPostValueException(String message, HttpStatus status) {
        super(message, status);
    }
}
