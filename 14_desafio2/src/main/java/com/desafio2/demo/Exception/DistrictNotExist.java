package com.desafio2.demo.Exception;

import org.springframework.http.HttpStatus;

public class DistrictNotExist extends GeneralException{
    public DistrictNotExist(String name) {
        super("District "+name+" not exist", HttpStatus.BAD_REQUEST);
    }
}
