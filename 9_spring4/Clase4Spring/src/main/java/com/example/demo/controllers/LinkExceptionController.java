package com.example.demo.controller;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(LinkInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkAlreadyExistException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkIdRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkIdRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkInvalidPasswordOrIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkInvalidPasswordOrIdException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkInvalidPasswordException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkInvalidPasswordException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
