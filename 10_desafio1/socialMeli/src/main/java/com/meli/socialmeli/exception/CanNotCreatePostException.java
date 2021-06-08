package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class CanNotCreatePostException extends SocialMeliException {

    public CanNotCreatePostException(Integer postId) {
        super("Already Existing Post ID:" + postId, HttpStatus.BAD_REQUEST);
    }
}
