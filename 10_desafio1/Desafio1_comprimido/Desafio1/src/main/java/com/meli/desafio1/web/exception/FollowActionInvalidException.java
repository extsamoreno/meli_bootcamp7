package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class FollowActionInvalidException extends UserException{
    public FollowActionInvalidException(int message, HttpStatus status) {
        super("The user: "+message +" can't follow user: " + message + ".", HttpStatus.BAD_REQUEST);
    }
}
