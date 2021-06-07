package com.example.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistURLException extends LinkException{
    public AlreadyExistURLException(String message, HttpStatus status) {
        super(message, status);
    }
}
