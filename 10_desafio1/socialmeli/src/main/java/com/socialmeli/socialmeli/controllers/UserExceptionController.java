package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.UserAlreadyFollowedException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.exceptions.UserSameIdException;
import com.socialmeli.socialmeli.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyFollowedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserSameIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserSameIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
