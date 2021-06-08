package com.springChallenge.api.controller.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GlobalException extends Exception{
    private String message, error;
    private HttpStatus status;

    public GlobalException(String message, HttpStatus status){
        this.message = message;
        this.status = status;
        this.error = this.getClass().getSimpleName();
    }
}
