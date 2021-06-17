package com.example.testingchallengev2.exception;

import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends CustomException{
    public HouseNotFoundException()
    {
        super("House not found in repository", HttpStatus.BAD_REQUEST);
    }
}
