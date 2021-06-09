package com.meli.spring_challenge.exception;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistException extends ProductException {
    public PostAlreadyExistException(int postID){
        super("The postID: "+postID+" already exist!", HttpStatus.BAD_REQUEST);
    }
}
