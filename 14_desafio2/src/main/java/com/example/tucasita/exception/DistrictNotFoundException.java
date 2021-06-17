package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends DistrictException{
    public DistrictNotFoundException(String districtName) {
        super("El barrio " + districtName + " no existe en el repositorio local ", HttpStatus.NOT_FOUND);
    }
}
