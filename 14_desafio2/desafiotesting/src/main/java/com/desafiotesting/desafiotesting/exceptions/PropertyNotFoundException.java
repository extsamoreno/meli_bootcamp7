package com.desafiotesting.desafiotesting.exceptions;
import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends CustomException{
    public PropertyNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
