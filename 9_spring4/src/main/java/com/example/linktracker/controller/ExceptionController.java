package com.example.linktracker.controller;

import com.example.linktracker.exception.LinkException;
import com.example.linktracker.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
