package com.meli.testingchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends EstateException {

    public DistrictNotFoundException(String districtName) {
        super("District ' " + districtName + " '  does not exist ", HttpStatus.BAD_REQUEST);
    }
}
