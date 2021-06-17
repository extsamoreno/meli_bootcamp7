package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ProductException{
    public DistrictNotFoundException(String message) {
        super("El distrito con nombre " + message + " no se encuentra.", HttpStatus.NOT_FOUND);
    }
}
