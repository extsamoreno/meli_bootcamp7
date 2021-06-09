package com.bootcamp.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException{

    public UserIdNotFoundException(Integer id){
        super("User with ID " + id + " not found", HttpStatus.BAD_REQUEST);
    }
}
