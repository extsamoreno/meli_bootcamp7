package com.meli.desafio.exceptions;

import org.springframework.http.HttpStatus;

public class PostNotExistException extends ExceptionModel{
    public PostNotExistException(Integer id){
        super("the post with the id " + id + " not exists", HttpStatus.BAD_REQUEST);
    }
}
