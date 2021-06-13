package com.digitalhouse.obtenerdiploma.controller;


import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import com.digitalhouse.obtenerdiploma.dto.ErrorValidationsDTO;
import com.digitalhouse.obtenerdiploma.exception.ValidationOutputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(),e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationsDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {

        ErrorValidationsDTO errorDTO = new ErrorValidationsDTO();
        errorDTO.setMessage("Error al validar los campos de ingreso.");
        errorDTO.setType(ex.getClass().getSimpleName());

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        errorDTO.setFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationOutputException.class)
    public ResponseEntity<ErrorValidationsDTO> validationOutputException(ValidationOutputException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }



}
