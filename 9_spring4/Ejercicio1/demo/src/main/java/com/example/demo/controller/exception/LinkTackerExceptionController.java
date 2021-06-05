package com.example.demo.controller.exception;


import com.example.demo.services.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URISyntaxException;

@ControllerAdvice
public class LinkTackerExceptionController {

    @ExceptionHandler(NotValidURLException.class)
    public ResponseEntity<ErrorDTO> notValidURL(NotValidURLException e){
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ErrorDTO> notFoundLink(NotFoundLinkException e){
        return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> notFoundLink(Exception e){
        return new ResponseEntity<>(new ErrorDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundLinkStatisticException.class)
    public ResponseEntity<ErrorDTO> notFoundLinkStatistic(NotFoundLinkException e){
        return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistLinkException.class)
    public ResponseEntity<ErrorDTO> existLinkException(ExistLinkException e){
        return new ResponseEntity<>(e.getError(),HttpStatus.BAD_REQUEST);
    }

}
