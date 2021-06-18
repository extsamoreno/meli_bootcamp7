package com.meli.desafio.exceptions.models;

import com.meli.desafio.exceptions.ExceptionModel;
import org.springframework.http.HttpStatus;

public class DistrictAlreadyExists extends ExceptionModel {
    public DistrictAlreadyExists(String name){
        super("The district " + name + " already exists", HttpStatus.BAD_REQUEST);
    }
}
