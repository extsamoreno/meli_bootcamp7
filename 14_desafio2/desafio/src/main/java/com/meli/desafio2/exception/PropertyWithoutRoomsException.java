package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyWithoutRoomsException extends PropertyException{

    public PropertyWithoutRoomsException() {
        super("La propiedad no tiene habitaciones.", HttpStatus.NOT_FOUND);
    }
}
