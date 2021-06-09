package com.bootcamp.desafio1.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends GeneralException{

    public PostNotFoundException(int postId) {
        super("The Post ID: " +postId+ " is not found in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
