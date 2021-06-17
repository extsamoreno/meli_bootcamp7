package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException{
    public PropertyNotFoundException(int idProperty) {
        super("La propiedad con ID " + idProperty + " no existe en el repositorio local ", HttpStatus.NOT_FOUND);
    }
}
