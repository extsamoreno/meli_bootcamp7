package com.bootcamp.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyRegisteredException extends UserException{

    public PostAlreadyRegisteredException(Integer id){
        super("Post with ID " + id + " already Registered", HttpStatus.BAD_REQUEST);
    }
}
