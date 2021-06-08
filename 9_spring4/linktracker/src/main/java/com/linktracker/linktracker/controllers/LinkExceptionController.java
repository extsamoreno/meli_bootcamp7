package com.linktracker.linktracker.controllers;
import com.linktracker.linktracker.exceptions.InvalidLinkException;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.exceptions.LinkNotValidToRedirectException;
import com.linktracker.linktracker.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

   @ExceptionHandler(LinkAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkAlreadyExistException e){
       return new ResponseEntity<>(e.getError(),e.getStatus());
   }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidLinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotValidToRedirectException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkNotValidToRedirectException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}
