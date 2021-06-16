package com.example.challenge_2.exception;

import org.springframework.http.HttpStatus;

public abstract class DistrictException extends WebException {
    public DistrictException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
