package com.meli.tu_casita.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends TuCasitaException{

    public DistrictNotFoundException(Integer id, String name) {
        super("District " + (name != null ? name:id) + " not found", HttpStatus.BAD_REQUEST);
    }
}
