package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class NonExistentFolloweException extends SocialMeliException{
    public NonExistentFolloweException(int id) {
        super("The user is not following the seller with id :" + id, HttpStatus.BAD_REQUEST);
    }
}
