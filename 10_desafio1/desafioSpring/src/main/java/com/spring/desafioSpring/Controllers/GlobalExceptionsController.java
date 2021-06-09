package com.spring.desafioSpring.Controllers;

import com.spring.desafioSpring.DTOs.ErrorDTO;
import com.spring.desafioSpring.Exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FollowYourselfException.class)
    public ResponseEntity<ErrorDTO> followYourselfxception(FollowYourselfException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostIdExistsException.class)
    public ResponseEntity<ErrorDTO> postIdExistsException(PostIdExistsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> propertyNotFoundException(PropertyNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }


}
