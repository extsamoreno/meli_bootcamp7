package com.example.desafio1.exception.user;

import org.springframework.http.HttpStatus;

public class UserFollowEqualsFollowerException extends UserException {

    public UserFollowEqualsFollowerException() {
        super("The follower is equals that followed", HttpStatus.BAD_REQUEST);
    }
}
