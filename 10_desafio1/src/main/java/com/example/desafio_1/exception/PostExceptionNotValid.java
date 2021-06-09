package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class PostExceptionNotValid extends ProductException{
    public PostExceptionNotValid(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
