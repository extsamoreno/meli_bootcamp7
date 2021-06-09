package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class NonSellerUserException extends SocialMeliException{
    public NonSellerUserException(int id) {
        super("The User with id `" + id + "` is not a seller", HttpStatus.BAD_REQUEST);
    }
}
