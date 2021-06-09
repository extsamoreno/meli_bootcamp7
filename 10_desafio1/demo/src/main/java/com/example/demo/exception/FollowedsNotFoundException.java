package com.example.demo.exception;

import com.example.demo.exception.GenericException;
import org.springframework.http.HttpStatus;

public class FollowedsNotFoundException extends GenericException {
    public FollowedsNotFoundException(Integer userId, Integer userFollowed) {
        super("El usuario " + userId+" no esta siguiendo a " + userFollowed, HttpStatus.BAD_REQUEST);
    }
}
