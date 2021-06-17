package com.example.ChallengeTwo.exception;

import org.springframework.http.HttpStatus;

public class HouseNameNotFoundException extends  ProgramException{
    public HouseNameNotFoundException(String houseName) {
        super("Name:  "+ houseName+" does not correspond to any House", HttpStatus.BAD_REQUEST);
    }
}
