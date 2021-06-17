package com.example.challenge2.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ApiException {
    public PropertyNotFoundException(String propertyName) {
        super("The property with the name " + propertyName + " was not found", HttpStatus.NOT_FOUND);
    }
}
