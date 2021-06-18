package com.tucasita.tasaciones.project.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyNameNotFoundException extends PropertyException{

    public PropertyNameNotFoundException(String propertyName){
        super("Error: propertyName "+ propertyName + " was not found", HttpStatus.BAD_REQUEST);
    }
}
