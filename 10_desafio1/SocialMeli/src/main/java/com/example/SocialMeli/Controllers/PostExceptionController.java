package com.example.SocialMeli.Controllers;


import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Services.DTOs.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    

}
