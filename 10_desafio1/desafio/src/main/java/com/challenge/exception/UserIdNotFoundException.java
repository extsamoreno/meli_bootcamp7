package com.challenge.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException{

    public UserIdNotFoundException() {
        super("User id not found", HttpStatus.BAD_REQUEST);
    }
}
