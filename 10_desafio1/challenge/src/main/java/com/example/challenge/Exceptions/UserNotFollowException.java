package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFollowException extends ApiException{

    public UserNotFollowException(int follower, int followed) {
        super("The User " + follower + " is already not following the User " + followed, HttpStatus.BAD_REQUEST);
    }
}
