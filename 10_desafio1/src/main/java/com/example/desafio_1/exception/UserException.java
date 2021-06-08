package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public abstract class UserException extends WebException {
    public UserException(String message, HttpStatus status) {
        super(message, status);
    }
}
