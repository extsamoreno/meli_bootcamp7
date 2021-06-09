package com.example.socialmeli.controllers;

import com.example.socialmeli.dtos.ErrorDTO;
import com.example.socialmeli.exceptions.postExceptions.PostException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
