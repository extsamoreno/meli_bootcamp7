package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyExists extends SocialException{
    public PostAlreadyExists(int postId) {
        super("post with id: " + postId +" already exists", HttpStatus.BAD_REQUEST);
    }
}
