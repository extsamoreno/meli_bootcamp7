package com.example.ChallengeTwo.exception;

import org.springframework.http.HttpStatus;

public class DistrictAlreadyExistsException extends ProgramException{
    public DistrictAlreadyExistsException (String districtName) {
        super("districtName:  "+ districtName +" There is already a district with that name", HttpStatus.BAD_REQUEST);
    }
}
