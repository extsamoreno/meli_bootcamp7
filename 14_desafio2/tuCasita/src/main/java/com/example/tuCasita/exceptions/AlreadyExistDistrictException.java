package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistDistrictException extends HomeException{
    public AlreadyExistDistrictException(Integer districtId) {
        super("The district " + districtId + " already exist", HttpStatus.BAD_REQUEST);
    }
}
