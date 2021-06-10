package com.reto1.demo.Controller;

import com.reto1.demo.Exception.GeneralException;
import com.reto1.demo.Exception.UserException.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FollowExceptionController {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorDTO> handleException(GeneralException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(UserIdNotFoundException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }
    @ExceptionHandler(UserAlreadyFollowException.class)
    public ResponseEntity<ErrorDTO> handleException(UserAlreadyFollowException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
