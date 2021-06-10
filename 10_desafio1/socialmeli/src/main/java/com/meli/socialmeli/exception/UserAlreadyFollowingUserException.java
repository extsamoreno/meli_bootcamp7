package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowingUserException extends SocialException{
    public UserAlreadyFollowingUserException() {
        super("User already followed ", HttpStatus.BAD_REQUEST);
    }
}
