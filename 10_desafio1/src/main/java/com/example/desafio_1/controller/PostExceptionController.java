package com.example.desafio_1.controller;

import com.example.desafio_1.exception.PostException;
import com.example.desafio_1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDTO> handlePostException(PostException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
