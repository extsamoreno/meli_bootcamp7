package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.exceptions.PostNotExistException;
import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.models.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostErrorException.class)
    public ResponseEntity<ErrorDTO> postErrorException(PostErrorException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostNotExistException.class)
    public ResponseEntity<ErrorDTO> postNotExistException(PostNotExistException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
