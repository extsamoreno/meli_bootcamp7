package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException{
    public UserAlreadyFollowedException(int user, int followed,  HttpStatus status) {
        super("The user with id: " + user + " already follows user with id: "+ followed, HttpStatus.BAD_REQUEST);
    }
}
