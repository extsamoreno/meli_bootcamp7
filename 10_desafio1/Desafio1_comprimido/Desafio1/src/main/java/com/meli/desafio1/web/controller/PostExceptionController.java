package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.ErrorDTO;
import com.meli.desafio1.web.exception.InvalidPostValueException;
import com.meli.desafio1.web.exception.PostAlreadyExistsException;
import com.meli.desafio1.web.exception.PostUserNotFoundException;
import com.meli.desafio1.web.exception.PostOrderNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostUserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostUserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidPostValueException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidPostValueException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostOrderNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostOrderNotValidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
