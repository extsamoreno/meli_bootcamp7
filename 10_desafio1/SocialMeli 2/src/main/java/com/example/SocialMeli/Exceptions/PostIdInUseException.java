package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class PostIdInUseException extends PostException{
    public PostIdInUseException(int postId) {
        super("Post ID: "+postId+" is already being used", HttpStatus.BAD_REQUEST);
    }
}
