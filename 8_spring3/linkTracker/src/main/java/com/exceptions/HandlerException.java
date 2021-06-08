package com.exceptions;

import com.models.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class HandlerException {

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ErrorDTO> invalidUrlException(InvalidUrlException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorDTO> wrongPasswordException(WrongPasswordException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> linkNotFoundException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
