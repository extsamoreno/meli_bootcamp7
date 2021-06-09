package com.SocialMeli.controller;

import org.springframework.http.HttpStatus;
import com.SocialMeli.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.SocialMeli.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

  @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

 @ExceptionHandler(UserIdFollowerEqualsFollowed.class)
public ResponseEntity<ErrorDTO> handleGlobalException(UserIdFollowerEqualsFollowed e){

     return new ResponseEntity<>(e.getError(),e.getStatus());
  }

}
