package com.meli.spring.controllers;

import com.meli.spring.exceptions.LinkException;
import com.meli.spring.exceptions.LinkIDNotFoundException;
import com.meli.spring.exceptions.LinkUnauthorizedException;
import com.meli.spring.services.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkIDNotFoundException.class)
    public  ResponseEntity<ErrorDto> handleGlobalException(LinkIDNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkUnauthorizedException.class)
    public  ResponseEntity<ErrorDto> handleGlobalException(LinkUnauthorizedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
