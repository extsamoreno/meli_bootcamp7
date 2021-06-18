package com.testingchallenge.tucasita.exception;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFoundException extends NeighborhoodException {

    public NeighborhoodNotFoundException (String name) {
        super("There's not property match for the name: " + name, HttpStatus.NOT_FOUND);
    }

}
