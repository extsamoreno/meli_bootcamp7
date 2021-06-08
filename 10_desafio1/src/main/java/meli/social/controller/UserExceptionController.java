package meli.social.controller;

import meli.social.exception.UserException;
import meli.social.exception.UserIdNotFoundException;
import meli.social.service.dto.UserErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<UserErrorDTO> handleGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
