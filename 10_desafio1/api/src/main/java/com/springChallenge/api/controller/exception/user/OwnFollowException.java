package com.springChallenge.api.controller.exception.user;

import org.springframework.http.HttpStatus;

public class OwnFollowException extends UserValidationsException {
    public OwnFollowException(){
        super("Can not follow own user", HttpStatus.BAD_REQUEST);
    }
}
