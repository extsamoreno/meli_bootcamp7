package com.bootcamp.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class FollowYourselfException extends UserException{

    public FollowYourselfException(){
        super("You can't follow yourself", HttpStatus.BAD_REQUEST);
    }
}
