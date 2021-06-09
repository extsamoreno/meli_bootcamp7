package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class PostExceptionNotExists extends ProductException {
    public PostExceptionNotExists(int postId) {
        super("A post with id:".concat(postId + "").concat(" don't exists"), HttpStatus.BAD_REQUEST);
    }
}
