package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.PostIdAlreadyExistException;
import com.meli.socialmeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(PostIdAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdAlreadyExistException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
