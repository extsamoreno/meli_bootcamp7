package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public abstract class PostException extends WebException {
    public PostException(String message, HttpStatus status) {
        super(message, status);
    }
}
