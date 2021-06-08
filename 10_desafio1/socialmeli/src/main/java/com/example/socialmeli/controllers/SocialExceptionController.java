package com.example.socialmeli.controllers;

import com.example.socialmeli.dtos.ErrorDTO;
import com.example.socialmeli.exceptions.SocialException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
