package meli.social.controller;

import meli.social.exception.PostIdRepeatedException;
import meli.social.exception.UserException;
import meli.social.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostIdRepeatedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdRepeatedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
