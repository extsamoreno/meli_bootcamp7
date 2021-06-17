package com.meli.tucasita.controller;

import com.meli.tucasita.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
    ErrorDto err = new ErrorDto();
    err.setName(ex.getClass().getSimpleName());

    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      err.getErrors().put(fieldName,errorMessage);
    });

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }
}
