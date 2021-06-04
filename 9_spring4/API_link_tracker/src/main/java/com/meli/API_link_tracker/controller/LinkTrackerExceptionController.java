package com.meli.API_link_tracker.controller;

import com.meli.API_link_tracker.model.dto.ErrorDTO;
import com.meli.API_link_tracker.model.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkTrackerExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException (LinkTrackerException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FormatLinkNotValidateException.class)
    public ResponseEntity<ErrorDTO> handleFormatLinkNotValidateException (FormatLinkNotValidateException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleIDNotFoundException (IDNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkAlreadyCreatedException.class)
    public ResponseEntity<ErrorDTO> handleLinkAlreadyCreatedException (LinkAlreadyCreatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkAlreadyInvalidatedException.class)
    public ResponseEntity<ErrorDTO> handleLinkAlreadyInvalidatedException (LinkAlreadyInvalidatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PasswordNotEnteredException.class)
    public ResponseEntity<ErrorDTO> handlePasswordNotEnteredException (PasswordNotEnteredException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}