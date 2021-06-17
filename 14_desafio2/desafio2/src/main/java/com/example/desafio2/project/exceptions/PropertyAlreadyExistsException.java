package com.example.desafio2.project.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistsException extends PropertyException{
    public PropertyAlreadyExistsException (String propertyName){
        super("Error: propertyName "+propertyName+" already exists", HttpStatus.BAD_REQUEST);
    }
}
