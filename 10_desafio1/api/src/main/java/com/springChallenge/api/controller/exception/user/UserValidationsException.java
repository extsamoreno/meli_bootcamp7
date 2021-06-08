package com.springChallenge.api.controller.exception.user;

import com.springChallenge.api.controller.exception.GlobalException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class UserValidationsException extends GlobalException {
    public UserValidationsException(String message, HttpStatus status){
        super(message, status);
    }
}
