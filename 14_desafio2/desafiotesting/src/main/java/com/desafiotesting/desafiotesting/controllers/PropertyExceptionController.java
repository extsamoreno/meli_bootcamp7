package com.desafiotesting.desafiotesting.controllers;
import com.desafiotesting.desafiotesting.exceptions.DistrictNotFoundException;
import com.desafiotesting.desafiotesting.exceptions.PropertyNotFoundException;
import com.desafiotesting.desafiotesting.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {
    @ExceptionHandler(DistrictNotFoundException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(PropertyNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
