package com.example.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidURLException extends LinkException {

    public InvalidURLException(String message, HttpStatus status) {
        super(message, status);
    }
}
