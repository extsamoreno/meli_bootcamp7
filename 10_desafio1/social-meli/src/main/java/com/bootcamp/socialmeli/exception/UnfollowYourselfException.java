package com.bootcamp.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UnfollowYourselfException extends UserException{

    public UnfollowYourselfException(){
        super("You can't unfollow yourself", HttpStatus.BAD_REQUEST);
    }
}
