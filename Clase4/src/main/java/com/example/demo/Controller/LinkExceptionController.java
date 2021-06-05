package com.example.demo.Controller;


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

}
