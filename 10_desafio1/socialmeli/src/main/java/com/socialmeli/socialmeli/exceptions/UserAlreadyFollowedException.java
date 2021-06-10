package com.socialmeli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends CustomException {
    public UserAlreadyFollowedException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }


}
