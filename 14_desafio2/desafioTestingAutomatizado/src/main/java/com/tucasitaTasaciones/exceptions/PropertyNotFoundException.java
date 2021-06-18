package com.tucasitaTasaciones.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ApplicationException {

    public PropertyNotFoundException(Integer id) {
        super("Property with ID: " + id + " doesn't exists", HttpStatus.BAD_REQUEST);
    }

}
