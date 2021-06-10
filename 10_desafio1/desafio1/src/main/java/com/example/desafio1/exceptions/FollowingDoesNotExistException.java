package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class FollowingDoesNotExistException extends ResponseException {
    public FollowingDoesNotExistException() {
        super("Cannot execute unfollow since this user is not currently following this seller", HttpStatus.BAD_REQUEST);
    }
}
