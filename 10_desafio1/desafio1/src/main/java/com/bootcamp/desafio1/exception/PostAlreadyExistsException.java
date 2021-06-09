package com.bootcamp.desafio1.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistsException extends GeneralException{


    public PostAlreadyExistsException(int postId) {
        super("The Post with ID: " +postId+ " already exists in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
