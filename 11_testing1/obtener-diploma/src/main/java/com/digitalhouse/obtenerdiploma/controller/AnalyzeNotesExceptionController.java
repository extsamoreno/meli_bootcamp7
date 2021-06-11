package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.exception.AnalyzeNotesException;
import com.digitalhouse.obtenerdiploma.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AnalyzeNotesExceptionController {

    @ExceptionHandler(AnalyzeNotesException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(AnalyzeNotesException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        return new ResponseEntity<>(new ErrorDTO(errors.toString(),ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
        //return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
