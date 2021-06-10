package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdNotFountException extends UserException {
    public UserIdNotFountException(int idUser) {
        super("the userid " + idUser + " not fount", HttpStatus.BAD_REQUEST);
    }
}
