package com.api.apiMask.controller;

import com.api.apiMask.controller.dto.ErrorDTO;
import com.api.apiMask.exception.LinkValidationException;
import com.api.apiMask.exception.URLAlreadyUsedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsController {

    @ExceptionHandler(URLAlreadyUsedException.class)
    public ResponseEntity<ErrorDTO> urlAlreadyUsedExceptionHandler(URLAlreadyUsedException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkValidationException.class)
    public ResponseEntity<ErrorDTO> linkValidationExceptionHandler(LinkValidationException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
