package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserNotExistsException extends SocialException{

    public UserNotExistsException(int userId) {
        super("User with id : " + userId + " does not exists" , HttpStatus.BAD_REQUEST);
    }

    public UserNotExistsException(String userName) {
        super("User with name : " + userName + " does not exists" , HttpStatus.BAD_REQUEST);
    }
}
