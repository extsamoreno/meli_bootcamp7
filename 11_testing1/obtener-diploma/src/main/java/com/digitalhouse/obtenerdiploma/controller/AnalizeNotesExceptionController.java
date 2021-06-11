package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.ErrorValidationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AnalizeNotesExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {

        return new ResponseEntity<>(new ErrorValidationDTO(ex.getClass().getSimpleName(),
                ex.getBindingResult().getAllErrors()), HttpStatus.BAD_REQUEST);
    }

}
