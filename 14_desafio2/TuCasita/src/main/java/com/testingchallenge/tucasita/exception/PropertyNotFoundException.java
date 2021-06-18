package com.testingchallenge.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {

    public PropertyNotFoundException (String name) {
        super("There's not property match for the name: " + name, HttpStatus.NOT_FOUND);
    }

}
