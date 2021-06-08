package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.ErrorDTO;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
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
}
