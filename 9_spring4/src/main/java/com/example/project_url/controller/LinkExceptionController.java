package com.example.project_url.controller;

import com.example.project_url.exception.LinkException;
import com.example.project_url.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException exception) {
        return new ResponseEntity<ErrorDTO>(exception.getError(), exception.getStatus());
    }
}
