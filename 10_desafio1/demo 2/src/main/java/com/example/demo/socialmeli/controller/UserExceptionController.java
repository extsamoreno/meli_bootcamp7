package com.example.demo.socialmeli.controller;
import com.example.demo.socialmeli.exception.FollowedExistingException;
import com.example.demo.socialmeli.exception.FollowedNotExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(FollowedExistingException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowedExistingException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(FollowedNotExistingException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowedNotExistingException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
}
