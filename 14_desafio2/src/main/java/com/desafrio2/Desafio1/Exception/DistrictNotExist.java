package com.desafrio2.Desafio1.Exception;

import org.springframework.http.HttpStatus;

public class DistrictNotExist extends GeneralException{
    public DistrictNotExist(String name) {
        super("District "+name+" not exist", HttpStatus.BAD_REQUEST);
    }
}
