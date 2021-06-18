package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends PropertyException{
    public DistrictNotFoundException() {
        super("This district is not registered on the database", HttpStatus.NOT_FOUND);
    }
}
