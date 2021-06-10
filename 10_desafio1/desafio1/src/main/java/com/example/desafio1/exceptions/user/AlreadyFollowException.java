package com.example.desafio1.exceptions.user;

import org.springframework.http.HttpStatus;

public class AlreadyFollowException extends UserException {
    public AlreadyFollowException(int userId) {
        super("Ya sigues al usuario: " + userId, HttpStatus.BAD_REQUEST);
    }
}
