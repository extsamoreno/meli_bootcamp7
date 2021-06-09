package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dto.ErrorDTO;
import com.meli.socialmeli.model.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException (SocialMeliException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ErrorOrderParamDateException.class)
    public ResponseEntity<ErrorDTO> handleErrorOrderParamDateException (ErrorOrderParamDateException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ErrorOrderParamNameException.class)
    public ResponseEntity<ErrorDTO> handleErrorOrderParamException (ErrorOrderParamNameException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleIdNotFoundException (IdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NonExistentFolloweException.class)
    public ResponseEntity<ErrorDTO> handleNonExistentFolloweException (NonExistentFolloweException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NonSellerUserException.class)
    public ResponseEntity<ErrorDTO> handleNonSellerUserException (NonSellerUserException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostIdAlreadyExistingException.class)
    public ResponseEntity<ErrorDTO> handlePostIdAlreadyExistingException (PostIdAlreadyExistingException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(RepeatFollowerException.class)
    public ResponseEntity<ErrorDTO> handleRepeatFollowerException (RepeatFollowerException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(SellerCanNotFollowException.class)
    public ResponseEntity<ErrorDTO> handleSellerCanNotFollowException (SellerCanNotFollowException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
