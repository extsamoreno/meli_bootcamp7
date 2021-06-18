package com.example.challenge2.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistException extends ApiException{
    public PropertyAlreadyExistException(String propertyName) {
        super("The property with the name " + propertyName + " exist", HttpStatus.NOT_FOUND);
    }
}
