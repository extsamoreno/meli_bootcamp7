package com.reto1.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowException extends GeneralException {
    public UserAlreadyFollowException(String name) {
        super("User "+name+" already was follow", HttpStatus.CONFLICT);
    }
}
