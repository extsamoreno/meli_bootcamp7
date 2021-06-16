package com.example.challenge_2.exception;

import org.springframework.http.HttpStatus;

public abstract class PropertyException extends WebException {
    public PropertyException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
