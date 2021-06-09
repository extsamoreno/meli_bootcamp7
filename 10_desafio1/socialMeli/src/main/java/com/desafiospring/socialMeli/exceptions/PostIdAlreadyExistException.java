package com.desafiospring.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistException extends PostException{
    public PostIdAlreadyExistException(int postId) {
        super("Post with ID:" + postId + " already exists", HttpStatus.BAD_REQUEST);
    }
}
