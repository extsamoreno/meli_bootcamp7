package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.ErrorDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.NoFollowerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorDTO> handleInvalidIdException(InvalidIdException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

    @ExceptionHandler(FollowerAlreadyAddedException.class)
    public ResponseEntity<ErrorDTO> handleFollowerAlreadyAddedException(FollowerAlreadyAddedException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

    @ExceptionHandler(NoFollowerException.class)
    public ResponseEntity<ErrorDTO> handleNoFollowerException(NoFollowerException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

}
