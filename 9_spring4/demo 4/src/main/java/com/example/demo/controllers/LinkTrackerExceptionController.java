package com.example.demo.controllers;

import com.example.demo.Exceptions.*;
import com.example.demo.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkTrackerExceptionController {

    @ExceptionHandler(UrlException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UrlException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DisableException.class)
    public ResponseEntity<ErrorDTO> handleDisableException(DisableException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(InvalidPassException.class)
    public ResponseEntity<ErrorDTO> handleIncorrectPasswordException(InvalidPassException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleLinkIdNotFoundException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UrlNotValidException.class)
    public ResponseEntity<ErrorDTO> handleLinkTrackerException(UrlNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
