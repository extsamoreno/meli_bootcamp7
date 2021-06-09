package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistingException extends SocialMeliException{
    public PostIdAlreadyExistingException(int id) {
        super("There is already a post with the same id: " + id, HttpStatus.BAD_REQUEST);
    }
}
