package com.example.desafio1.exception.post;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends PostException {

    public PostNotFoundException(Integer postId) {
        super("ID: " + postId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
