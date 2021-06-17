package com.tucasitatasaciones.tucasitatasaciones.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends TuCasitaException {
    public DistrictNotFoundException(int districtId) {
        super("No se encuentra el barrio con el id: " + districtId, HttpStatus.NOT_FOUND);
    }
}
