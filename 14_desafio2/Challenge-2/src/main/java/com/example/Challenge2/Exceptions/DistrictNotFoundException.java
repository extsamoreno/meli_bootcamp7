package com.example.Challenge2.Exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends DistricticException{
    public DistrictNotFoundException(Long districtId) {
        super("District: "+districtId+" not found", HttpStatus.NOT_FOUND);
    }
}
