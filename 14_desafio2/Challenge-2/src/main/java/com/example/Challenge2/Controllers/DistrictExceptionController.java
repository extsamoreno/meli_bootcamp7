package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Services.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DistrictExceptionController {


    @ExceptionHandler(DistrictNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

}
