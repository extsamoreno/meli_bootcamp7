package com.tucasitaTasaciones.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ApplicationException {

    public DistrictNotFoundException(String district) {
        super("District with name: " + district + " doesn't exists", HttpStatus.BAD_REQUEST);
    }
}
