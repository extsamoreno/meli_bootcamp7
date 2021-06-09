package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowException extends ApiException {

    public UserAlreadyFollowException(int follower, int followed) {
        super("The User " + follower + " is already following the User " + followed, HttpStatus.BAD_REQUEST);
    }
}
