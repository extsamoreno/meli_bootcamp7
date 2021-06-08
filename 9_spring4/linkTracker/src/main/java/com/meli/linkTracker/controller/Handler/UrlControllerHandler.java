package com.meli.linkTracker.controller.Handler;

import com.meli.linkTracker.exception.InvalidFormatUrlException;
import com.meli.linkTracker.exception.InvalidIdUrlException;
import com.meli.linkTracker.exception.UrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Logger;

@ControllerAdvice
public class UrlControllerHandler {

    @ExceptionHandler(UrlException.class)
    public ResponseEntity<String> UrlHandler(UrlException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidFormatUrlException.class)
    public ResponseEntity<String> invalidFormatUrlHandler(InvalidFormatUrlException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidIdUrlException.class)
    public ResponseEntity<String> invalidIdUrlHandler(InvalidIdUrlException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
