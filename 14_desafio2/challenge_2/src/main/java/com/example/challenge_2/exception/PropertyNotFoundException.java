package com.example.challenge_2.exception;

public class PropertyNotFoundException extends PropertyException {
    public PropertyNotFoundException(int propertyId) {
        super("Property with id: ".concat(propertyId + "").concat(" not found"));
    }
}
