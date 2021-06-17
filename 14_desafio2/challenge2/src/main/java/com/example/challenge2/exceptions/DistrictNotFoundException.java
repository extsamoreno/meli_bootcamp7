package com.example.challenge2.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ApiException {
    public DistrictNotFoundException(String districtName) {
        super("The district with the name " + districtName + " was not found", HttpStatus.NOT_FOUND);
    }
}
