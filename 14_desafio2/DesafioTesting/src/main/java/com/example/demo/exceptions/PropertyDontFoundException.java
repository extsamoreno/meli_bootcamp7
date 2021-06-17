package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyDontFoundException extends ResponseException{
    public PropertyDontFoundException(int propId) {
        super("La propiedad con id "+ propId +" no existe", HttpStatus.NOT_FOUND);
    }
}
