package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.ErrorDTO;
import com.meli.socialmeli.exception.SocialMeliException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
