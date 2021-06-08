package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class FollowAlreadyExistException extends SocialException{
    public FollowAlreadyExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
