package com.meli.desafio.exceptions.models;

import com.meli.desafio.exceptions.ExceptionModel;
import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends ExceptionModel {
    public HouseNotFoundException(Integer id){
        super("The house with id " + id + "not exists", HttpStatus.BAD_REQUEST);
    }
}
