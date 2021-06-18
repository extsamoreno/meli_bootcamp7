package com.meli.tucasita.controller;

import com.meli.tucasita.dto.ErrorDto;
import com.meli.tucasita.dto.ErrorValidDto;
import com.meli.tucasita.exception.PropertyDistrictIdNotFoundException;
import com.meli.tucasita.exception.PropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> handleGlobalException(PropertyException e){
    return new ResponseEntity<>(e.getError(),e.getStatus());
  }

  @ExceptionHandler(PropertyDistrictIdNotFoundException.class)
  public ResponseEntity<ErrorDto> handleGlobalException(PropertyDistrictIdNotFoundException e){
    return new ResponseEntity<>(e.getError(),e.getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorValidDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
    ErrorValidDto err = new ErrorValidDto();
    err.setName(ex.getClass().getSimpleName());

    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      err.getErrors().put(fieldName,errorMessage);
    });

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }
}
