package com.socialMeli.product.exceptions;

import com.socialMeli.user.exceptions.UserIdNotFoundException;
import com.socialMeli.user.exceptions.UserNotFoundException;
import com.socialMeli.user.models.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(FailCreatePostException.class)
    public ResponseEntity<ErrorDTO> failCreatePostException(FailCreatePostException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
