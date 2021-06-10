package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.ErrorDTO;
import com.example.socialmeli.exceptions.UserFollowthisUserException;
import com.example.socialmeli.exceptions.UserIdNotFountException;
import com.example.socialmeli.exceptions.UserUnfollowthisUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(UserFollowthisUserException.class)
    public ResponseEntity<ErrorDTO> handlerGlobalException(UserFollowthisUserException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserUnfollowthisUserException.class)
    public ResponseEntity<ErrorDTO> handlerGlobalException(UserUnfollowthisUserException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(UserIdNotFountException.class)
    public ResponseEntity<ErrorDTO> handlerGlobalException(UserIdNotFountException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
