package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends SocialMeliException{
    public IdNotFoundException(int id) {
        super("No user found with the following ID: " + id, HttpStatus.BAD_REQUEST);
    }
}
