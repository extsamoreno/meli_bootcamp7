package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> userIdNotFoundException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FailCreatePostException.class)
    public ResponseEntity<ErrorDTO> failCreatePostException(FailCreatePostException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FailLoadDatabase.class)
    public ResponseEntity<ErrorDTO> failLoadDatabase(FailLoadDatabase e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FailUploadDatabase.class)
    public ResponseEntity<ErrorDTO> failUploadDatabase(FailUploadDatabase e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ErrorDTO> invalidDateException(InvalidDateException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(WrongCriteriaOrderException.class)
    public ResponseEntity<ErrorDTO> wrongCriteriaOrderException(WrongCriteriaOrderException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
