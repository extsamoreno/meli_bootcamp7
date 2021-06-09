package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.exception.DateIsNotValidException;
import com.example.desafiospring.socialmeli.exception.PostIdAlreadyExistException;
import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(PostIdAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DateIsNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DateIsNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}