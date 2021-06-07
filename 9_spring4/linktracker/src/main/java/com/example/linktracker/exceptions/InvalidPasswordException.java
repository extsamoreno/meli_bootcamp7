package com.example.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends LinkException{
    public InvalidPasswordException(String message, HttpStatus status) {
        super(message, status);
    }
}
