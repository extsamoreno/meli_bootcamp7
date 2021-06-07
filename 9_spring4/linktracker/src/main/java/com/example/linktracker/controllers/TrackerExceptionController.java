package com.example.linktracker.controllers;

import com.example.linktracker.dtos.ErrorDTO;
import com.example.linktracker.exceptions.InvalidURLException;
import com.example.linktracker.exceptions.LinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackerExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

   /* @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }*/
}
