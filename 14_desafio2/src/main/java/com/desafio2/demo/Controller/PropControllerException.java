package com.desafio2.demo.Controller;

import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.DTO.ErrorDTO;
import com.desafio2.demo.Model.DTO.ErrorDTOValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropControllerException {

    @ExceptionHandler(DistrictNotExist.class)
    public ResponseEntity<ErrorDTO> handlerException(DistrictNotExist e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTOValid> handlerException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorDTOValid(e.getBindingResult().getAllErrors()), HttpStatus.BAD_REQUEST);
    }

}
