package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super("No eres seguidor.", HttpStatus.BAD_REQUEST);
    }
}
