package com.example.desafio2.project.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyDistrictNameNotFoundException extends PropertyException{
    public PropertyDistrictNameNotFoundException (String districtName){
        super("Error: districtName "+districtName+" was not found", HttpStatus.BAD_REQUEST);
    }
}
