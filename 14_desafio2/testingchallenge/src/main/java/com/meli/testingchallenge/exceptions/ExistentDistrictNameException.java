package com.meli.testingchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentDistrictNameException extends EstateException {

    public ExistentDistrictNameException(String districtName) {
        super("District name' " + districtName + " '  is already in use ", HttpStatus.BAD_REQUEST);
    }
}
