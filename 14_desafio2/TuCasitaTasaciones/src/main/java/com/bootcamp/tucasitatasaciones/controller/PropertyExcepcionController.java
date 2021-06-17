package com.bootcamp.tucasitatasaciones.controller;

import com.bootcamp.tucasitatasaciones.DTO.ErrorDTO;
import com.bootcamp.tucasitatasaciones.DTO.ErrorValidationDTO;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExcepcionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {

        return new ResponseEntity<>(new ErrorValidationDTO(ex.getClass().getSimpleName(),
                ex.getBindingResult().getAllErrors()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }
}
