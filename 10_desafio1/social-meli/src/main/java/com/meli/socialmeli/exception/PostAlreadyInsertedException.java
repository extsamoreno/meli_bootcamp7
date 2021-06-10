package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyInsertedException extends ApiException {
    public PostAlreadyInsertedException(Integer userId, Integer postId) {
        super("The post " + postId + " is already inserted by user " + userId, HttpStatus.BAD_REQUEST);
    }
}
