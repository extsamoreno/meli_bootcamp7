package com.example.challenge2.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictAlreadyExistException extends ApiException{
    public DistrictAlreadyExistException(String districtName) {
        super("The district with the name " + districtName + " exist", HttpStatus.NOT_FOUND);
    }
}
