package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> handleGlobalUserException(UserException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(ExistentUserException.class)
    public ResponseEntity<ErrorDTO> handleExistentUserException(ExistentUserException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(InexistentUserException.class)
    public ResponseEntity<ErrorDTO> handleInexistentUserException(InexistentUserException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(ExistentFollowerException.class)
    public ResponseEntity<ErrorDTO> handleExistentFollowerException(ExistentFollowerException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(InexistentFollowerException.class)
    public ResponseEntity<ErrorDTO> handleInexistentFollowerException(InexistentFollowerException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(InvalidFollowerException.class)
    public ResponseEntity<ErrorDTO> handleInvalidFollowerException(InvalidFollowerException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorDTO> handleGlobalOrderException(OrderException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(InexistentNameOrderException.class)
    public ResponseEntity<ErrorDTO> handleInexistentOrderException(InexistentNameOrderException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDTO> handleGlobalPostException(PostException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(ExistentPostException.class)
    public ResponseEntity<ErrorDTO> handleExistentExistentPostException(ExistentPostException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(ExistentPromoPostException.class)
    public ResponseEntity<ErrorDTO> handleExistentPromoPostException(ExistentPromoPostException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }
}
