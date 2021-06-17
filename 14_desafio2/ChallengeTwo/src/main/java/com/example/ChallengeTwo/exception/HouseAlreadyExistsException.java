package com.example.ChallengeTwo.exception;

import org.springframework.http.HttpStatus;

public class HouseAlreadyExistsException extends ProgramException{
    public HouseAlreadyExistsException (String houseName) {
        super("Name:  "+ houseName +" There is already a house with that namet", HttpStatus.BAD_REQUEST);
    }
}
