package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dto.ErrorDTO;
import com.meli.socialmeli.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> errorDTOResponseEntity(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserInvalidException.class)
    public ResponseEntity<ErrorDTO> errorDTOResponseEntity(UserInvalidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserIsNotMerchant.class)
    public ResponseEntity<ErrorDTO> UserIsNotMerchant(UserIsNotMerchant e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserItselfException.class)
    public ResponseEntity<ErrorDTO> UserItselfException(UserItselfException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(  UserDoNotExistsException.class)
    public ResponseEntity<ErrorDTO> UserItselfException(UserDoNotExistsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
