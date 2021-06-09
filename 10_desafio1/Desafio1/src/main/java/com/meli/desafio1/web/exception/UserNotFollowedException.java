package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class UserNotFollowedException extends UserException{
    public UserNotFollowedException(int user, int followed,  HttpStatus status) {
        super("The user with id: " + user + " does not follow user with id: "+ followed, HttpStatus.BAD_REQUEST);
    }
}
