package com.meli.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException{
    public PropertyNotFoundException(String name){
        super("The property with name "+name+" was not found", HttpStatus.NOT_FOUND);
    }
}
