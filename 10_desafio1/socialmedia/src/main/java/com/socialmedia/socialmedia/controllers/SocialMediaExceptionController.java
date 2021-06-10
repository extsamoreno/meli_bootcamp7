package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMediaExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleSocialMediaException(SocialMediaException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserExistAsFollowerException.class)
    public ResponseEntity<ErrorDTO> handleUserExistAsFollowerException(UserExistAsFollowerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserNotExistAsFollowerException.class)
    public ResponseEntity<ErrorDTO> handleUserNotExistAsFollowerException(UserNotExistAsFollowerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleObjectNotFoundException(ObjectNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
