package com.meli.desafio.exceptions.controllers;

import com.meli.desafio.exceptions.models.dto.ErrorDTO;
import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e) {
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