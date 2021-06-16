package com.TuCasitaTasacionesAPI.TuCasita.controllers;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.ErrorDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerExceptions {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> propertyNotFoundException(PropertyNotFoundException ex){
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }
}
