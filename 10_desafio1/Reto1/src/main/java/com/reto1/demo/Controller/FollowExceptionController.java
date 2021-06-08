package com.reto1.demo.Controller;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FollowExceptionController {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(UserIdNotFoundException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }
    @ExceptionHandler(UserAlreadyFollowException.class)
    public ResponseEntity<ErrorDTO> handleException(UserAlreadyFollowException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
