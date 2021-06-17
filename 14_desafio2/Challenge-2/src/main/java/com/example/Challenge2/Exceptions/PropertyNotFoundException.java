package com.example.Challenge2.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException{
    public PropertyNotFoundException(Long propertyId) {
        super("Property: "+propertyId+" not found", HttpStatus.NOT_FOUND);
    }
}
