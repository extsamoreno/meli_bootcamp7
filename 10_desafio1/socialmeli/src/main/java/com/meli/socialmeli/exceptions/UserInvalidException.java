package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;


public class UserInvalidException extends UserException {
    public UserInvalidException() {
        super("El vendedor ya está en la lista de seguidos.", HttpStatus.BAD_REQUEST);
    }
}