package com.desafiotesting.desafiotesting.exceptions;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends CustomException {
    public DistrictNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
