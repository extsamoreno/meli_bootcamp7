package com.socialmeli.socialmeli.exceptions;
import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistException extends CustomException {
    public PostIdAlreadyExistException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
