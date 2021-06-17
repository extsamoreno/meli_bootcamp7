package com.example.ChallengeTwo.exception;

import org.springframework.http.HttpStatus;

public class DistrictNameNotFoundException extends ProgramException{
    public DistrictNameNotFoundException (String districtName) {
        super("districtName:  "+ districtName +" does not correspond to any District", HttpStatus.BAD_REQUEST);
    }
}
