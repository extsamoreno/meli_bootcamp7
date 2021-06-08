package com.example.LinkTracker.Controllers;

import com.example.LinkTracker.Exceptions.InvalidLinkException;
import com.example.LinkTracker.Exceptions.LinkNotFoundException;
import com.example.LinkTracker.Services.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidLinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
