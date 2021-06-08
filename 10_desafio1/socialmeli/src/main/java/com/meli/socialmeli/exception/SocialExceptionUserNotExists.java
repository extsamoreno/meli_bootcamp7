package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class SocialExceptionUserNotExists extends SocialException{

    public SocialExceptionUserNotExists(int userId) {
        super("User with id : " + userId + " does not exists" , HttpStatus.BAD_REQUEST);
    }

    public SocialExceptionUserNotExists(String userName) {
        super("User with name : " + userName + " does not exists" , HttpStatus.BAD_REQUEST);
    }
}
