package com.meli.tucasita.controller;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerException {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
