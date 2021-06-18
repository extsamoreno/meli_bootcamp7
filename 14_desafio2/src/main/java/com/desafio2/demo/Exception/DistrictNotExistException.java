package com.desafio2.demo.Exception;

import org.springframework.http.HttpStatus;

public class DistrictNotExistException extends GeneralException{
    public DistrictNotExistException(String name) {
        super("District "+name+" not exist", HttpStatus.BAD_REQUEST);
    }
}
