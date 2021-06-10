package com.example.desafiospring.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistException extends SocialMeliException {
    public PostIdAlreadyExistException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

//exception mensaje con status notfound