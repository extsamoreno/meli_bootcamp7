package com.meli.desafio.exceptions;

import org.springframework.http.HttpStatus;

public class PostErrorException extends ExceptionModel{
    public PostErrorException(Integer id) {
        super("the post with the id " + id + " already exists", HttpStatus.BAD_REQUEST);
    }
}
