package com.meli.tu_casita.exception;

import org.springframework.http.HttpStatus;

public class DistrictAlreadyExistsException extends TuCasitaException {
    public DistrictAlreadyExistsException(String districtName) {
        super("District " + districtName + " already exists", HttpStatus.BAD_REQUEST);
    }
}
