package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowException extends UserException {

    public UserAlreadyFollowException() {
        super("the follower already follows this user", HttpStatus.BAD_REQUEST);
    }
}
