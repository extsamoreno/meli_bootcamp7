package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyFollowedException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserAlreadyUnfollowedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyUnfollowedException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
