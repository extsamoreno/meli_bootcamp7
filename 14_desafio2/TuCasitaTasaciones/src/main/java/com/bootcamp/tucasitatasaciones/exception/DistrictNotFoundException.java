package com.bootcamp.tucasitatasaciones.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DistrictNotFoundException extends PropertyException {

    public DistrictNotFoundException(String districtName) {
        super("Barrio ".concat(districtName).concat(" no encontrado"), HttpStatus.NOT_FOUND);
    }
}
