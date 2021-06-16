package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException{
    public UserAlreadyFollowedException(int user, int followed,  HttpStatus status) {
        super("The user: " + user + " already follows user: "+ followed, HttpStatus.BAD_REQUEST);
    }
}
