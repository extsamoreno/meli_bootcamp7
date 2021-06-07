package com.example.LinkTracker.controller;

import com.example.LinkTracker.exception.LinkException;
import com.example.LinkTracker.exception.LinkIdNotFoundException;
import com.example.LinkTracker.service.DTOs.Response.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkIdNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
