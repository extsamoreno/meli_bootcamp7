package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> userExeptionHandler(UserException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
