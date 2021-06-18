package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends PropertyException{
    public DistrictNotFoundException(String district){
        super("El barrio " + district + "no se encuentra.", HttpStatus.BAD_REQUEST);
    }
}
