package com.meli.tucasitatasaciones.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ApiException {
    public DistrictNotFoundException(String districtName) {
        super("El barrio " + districtName + " no existe en la base de datos", HttpStatus.NOT_FOUND);
    }
}
