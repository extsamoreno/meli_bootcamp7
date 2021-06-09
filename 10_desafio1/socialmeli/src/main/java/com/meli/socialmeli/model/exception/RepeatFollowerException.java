package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class RepeatFollowerException extends SocialMeliException{
    public RepeatFollowerException(int id) {
        super("The user with id `" + id + "` is already following the seller", HttpStatus.BAD_REQUEST);
    }
}
