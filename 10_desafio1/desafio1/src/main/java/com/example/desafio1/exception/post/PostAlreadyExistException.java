package com.example.desafio1.exception.post;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistException extends PostException {

    public PostAlreadyExistException(Integer postId) {
        super("Post id " + postId + " already exists", HttpStatus.BAD_REQUEST);
    }
}
