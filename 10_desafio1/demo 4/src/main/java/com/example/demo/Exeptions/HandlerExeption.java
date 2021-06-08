package com.example.demo.Exeptions;


import com.example.demo.Services.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExeption{

    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<ErrorDTO> BadRequestExeption(BadRequestExeption ex){
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getErrorMessage()));
    }
}
