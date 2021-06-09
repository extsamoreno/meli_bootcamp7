package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super("El usiario no era seguidor.", HttpStatus.BAD_REQUEST);
    }
}
