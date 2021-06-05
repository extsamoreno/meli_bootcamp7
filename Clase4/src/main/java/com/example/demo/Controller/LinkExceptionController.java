package com.example.demo.Controller;


import com.example.demo.Exception.BadPasswordExpection;
import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTOResponse.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(LinkIdNotFoundException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvaidLinkException.class)
    public ResponseEntity<ErrorDTO> handleException(InvaidLinkException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(BadPasswordExpection.class)
    public ResponseEntity<ErrorDTO> handleException(BadPasswordExpection e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }
    @ExceptionHandler(DuplicatedLinkException.class)
    public ResponseEntity<ErrorDTO> handleException(DuplicatedLinkException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
