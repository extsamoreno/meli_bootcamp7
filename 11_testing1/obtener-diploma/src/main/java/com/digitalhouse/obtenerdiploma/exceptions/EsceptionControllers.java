package com.digitalhouse.obtenerdiploma.exceptions;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EsceptionControllers extends Exception {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handlerGlobalException(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}