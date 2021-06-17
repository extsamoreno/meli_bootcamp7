package com.meli.desafio.exceptions.models;

import com.meli.desafio.exceptions.ExceptionModel;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ExceptionModel {
    public DistrictNotFoundException(Integer id){
        super("The district with the id " + id + " is not found", HttpStatus.BAD_REQUEST);
    }
}
