package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class DistrictIdNotFoundException extends PropertyException {

    public DistrictIdNotFoundException(Integer distId){
        super("District id: " + distId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
