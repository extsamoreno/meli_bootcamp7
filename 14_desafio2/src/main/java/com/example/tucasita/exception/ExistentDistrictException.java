package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class ExistentDistrictException extends DistrictException{
    public ExistentDistrictException(String districtName) {
        super("El barrio " + districtName + " , que quiere crear, ya existe en el repositorio local ", HttpStatus.CONFLICT);
    }
}
