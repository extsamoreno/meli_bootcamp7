package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;


public class UserInvalidException extends UserException {
    public UserInvalidException() {
        super("El usiario  no puede ser seguido.", HttpStatus.BAD_REQUEST);
    }
}