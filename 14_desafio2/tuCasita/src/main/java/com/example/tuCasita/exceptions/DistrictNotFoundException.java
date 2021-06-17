package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends HomeException{
    public DistrictNotFoundException(Integer districtId) {
        super("The district " + districtId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
