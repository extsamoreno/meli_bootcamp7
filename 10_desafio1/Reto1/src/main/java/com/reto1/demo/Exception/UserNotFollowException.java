package com.reto1.demo.Exception;


import org.springframework.http.HttpStatus;

public class UserNotFollowException extends GeneralException {
    public UserNotFollowException(String name) {
        super("User "+name+" had not being follow before", HttpStatus.CONFLICT);
    }
}
