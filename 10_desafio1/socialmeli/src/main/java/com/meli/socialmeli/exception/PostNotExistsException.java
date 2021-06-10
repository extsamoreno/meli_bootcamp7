package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostNotExistsException extends SocialException{
    public PostNotExistsException(int postId) {
        super("post with id: " + postId + " does not exists", HttpStatus.BAD_REQUEST);
    }
}
