package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.ErrorDTO;
import com.bootcamp.linktracker.exception.LinkIdNotFoundException;
import com.bootcamp.linktracker.exception.LinkPasswordNotCorrect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkIdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(LinkPasswordNotCorrect.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkPasswordNotCorrect e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler({URISyntaxException.class, MalformedURLException.class})
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getClass().getSimpleName(), "Malformed URL");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
