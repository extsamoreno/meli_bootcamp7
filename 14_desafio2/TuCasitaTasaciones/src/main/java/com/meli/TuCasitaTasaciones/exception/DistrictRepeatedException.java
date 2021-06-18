package com.meli.TuCasitaTasaciones.exception;

import org.springframework.http.HttpStatus;

public class DistrictRepeatedException extends PropertyException {

    public DistrictRepeatedException(String districtName) {
        super("El barrio " + districtName + " ya se encuentra registrado.", HttpStatus.BAD_REQUEST);
    }
}
