package com.example.testingchallengev2.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends CustomException{
    public DistrictNotFoundException()
    {
        super("District not found in repository", HttpStatus.BAD_REQUEST);
    }
}
