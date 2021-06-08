package com.api.apiMask.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotCorrectException extends LinkValidationException{
    public PasswordNotCorrectException(){
        super("The password is not correct", HttpStatus.BAD_REQUEST);
    }
}
