package com.api.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostIdExistsException extends SocialMeliException{
    public PostIdExistsException() {
        super("Post Id Exists", HttpStatus.BAD_REQUEST);
    }
}
