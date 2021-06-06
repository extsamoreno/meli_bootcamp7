package com.spring4.spring4.Controllers;

import com.spring4.spring4.DTOs.ErrorDTO;
import com.spring4.spring4.Exceptions.InvalidLinkPassException;
import com.spring4.spring4.Exceptions.LinkInactiveException;
import com.spring4.spring4.Exceptions.LinkNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsController {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> linkNotFoundException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkInactiveException.class)
    public ResponseEntity<ErrorDTO> linkInactiveException(LinkInactiveException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidLinkPassException.class)
    public ResponseEntity<ErrorDTO> invalidLinkPassException(InvalidLinkPassException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
