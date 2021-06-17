package meli.bootcamp.tucasita.controller;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(PropertyNotFoundException e) {
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }
}
