package com.meli.desafio2.unit.controller;

import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.unit.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

    @ExceptionHandler(PropertyException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(PropertyException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        final StringBuilder builder = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            builder.append(fieldName + " - " + errorMessage + "    ^    ");
        });

        String errors = builder.toString();
        return new ResponseEntity<>(new ErrorDTO(errors, e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage().split(" \\(")[0], e.getClass().getSimpleName()),HttpStatus.BAD_REQUEST);
    }

}
