package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class PostExceptionAlreadyExists extends ProductException {
    public PostExceptionAlreadyExists(int postId) {
        super("A post with id:".concat(postId + "").concat(" already exists"), HttpStatus.BAD_REQUEST);
    }

}

