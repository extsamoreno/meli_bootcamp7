package com.spring4.linktracker.controller;

import com.spring4.linktracker.exception.TrackerException;
import com.spring4.linktracker.exception.TrackerIdNotFoundException;
import com.spring4.linktracker.service.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackerExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(TrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(TrackerIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(TrackerIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

