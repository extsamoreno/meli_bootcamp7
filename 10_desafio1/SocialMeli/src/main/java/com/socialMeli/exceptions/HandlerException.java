package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(SocialMeliException.class)
    public ResponseEntity<ErrorDTO> socialMeliException(SocialMeliException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
