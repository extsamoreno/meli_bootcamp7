package com.meli.tucasita.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends DistrictException{
    public DistrictNotFoundException(String name){
        super("The district with name "+name+" was not found", HttpStatus.NOT_FOUND);
    }
}
