package com.springChallenge.api.controller.exception;

import com.springChallenge.api.controller.dto.ErrorDTO;
import com.springChallenge.api.controller.exception.user.AlreadyFollowedException;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.controller.exception.user.UserValidationsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(UserValidationsException.class)
    public ResponseEntity<ErrorDTO> userNotFoundExceptionHandler(UserValidationsException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(), e.getError()), HttpStatus.BAD_REQUEST);
    }
}
