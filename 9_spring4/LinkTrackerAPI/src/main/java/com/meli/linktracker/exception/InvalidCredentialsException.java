package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends LinkException{
    public InvalidCredentialsException(String message, HttpStatus status){
        super(message, status);
    }
}
