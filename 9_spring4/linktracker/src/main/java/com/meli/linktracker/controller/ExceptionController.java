package com.meli.linktracker.controller;

import com.meli.linktracker.exception.LinkException;
import com.meli.linktracker.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException exception) {
        return new ResponseEntity<ErrorDTO>(exception.getError(), exception.getStatus());
    }
}
