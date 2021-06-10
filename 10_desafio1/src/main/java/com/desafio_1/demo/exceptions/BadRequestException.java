package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ResponseException{
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
