package com.example.demo.controlers;

import com.example.demo.dtos.ErrorDTO;
import com.example.demo.exceptions.LinkException;
import com.example.demo.exceptions.UrlNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(UrlNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UrlNotValidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
