package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(CanNotCreatePostException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(CanNotCreatePostException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(IdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidDateFormatException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }


}
