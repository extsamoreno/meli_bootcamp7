package com.tucasitatasaciones.tucasitatasaciones.controllers;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.TuCasitaException;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TuCasitaExceptionController {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(TuCasitaException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(OwnershipNotFoundException.class)
    ResponseEntity<ErrorDTO> handleOwnershipNotFoundException(OwnershipNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
