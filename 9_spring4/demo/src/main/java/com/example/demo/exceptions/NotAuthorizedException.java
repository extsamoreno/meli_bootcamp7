package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class NotAuthorizedException extends LinkException {

    public NotAuthorizedException(String message, HttpStatus status) {
        super(message, status);
    }
}
