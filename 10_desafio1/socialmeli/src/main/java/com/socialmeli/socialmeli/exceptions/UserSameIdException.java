package com.socialmeli.socialmeli.exceptions;
import org.springframework.http.HttpStatus;

public class UserSameIdException extends CustomException{
    public UserSameIdException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
