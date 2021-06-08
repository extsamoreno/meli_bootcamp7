package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UnhandledException extends ResponseException{
    public UnhandledException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
