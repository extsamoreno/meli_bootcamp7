package com.meli.desafio.exceptions.models;

import com.meli.desafio.exceptions.ExceptionModel;
import org.springframework.http.HttpStatus;

public class HouseAlreadyExistsException extends ExceptionModel {
    public HouseAlreadyExistsException(String name){
        super("The house with the name " + name + " already exists", HttpStatus.BAD_REQUEST);
    }
}
