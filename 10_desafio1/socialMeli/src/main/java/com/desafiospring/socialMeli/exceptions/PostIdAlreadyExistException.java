package com.desafiospring.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistException extends PostException{
    public PostIdAlreadyExistException(int postId) {
        super("User with ID:" + postId + " not found", HttpStatus.BAD_REQUEST);
    }
}
