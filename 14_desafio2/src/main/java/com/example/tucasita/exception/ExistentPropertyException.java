package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class ExistentPropertyException extends PropertyException{
    public ExistentPropertyException(int idProperty) {
        super("La propiedad con ID " + idProperty + " que quiere crear, ya existe en el repositorio local ", HttpStatus.CONFLICT);
    }
}
