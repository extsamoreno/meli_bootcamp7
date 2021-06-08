package com.desafiospring.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException(int id) {
        super("User with ID:" + id + " not found", HttpStatus.NOT_FOUND);
    }

}
