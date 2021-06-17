package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Services.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {




    @ExceptionHandler(PropertyNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handlePropertyNotFoundException(PropertyNotFoundException e) {
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

}
