package com.meli.desafio1.web.exception;

import org.springframework.http.HttpStatus;

public class UserNotFollowedException extends UserException{
    public UserNotFollowedException(int user, int followed,  HttpStatus status) {
        super("The user: " + user + " does not follow user: "+ followed, HttpStatus.BAD_REQUEST);
    }
}
