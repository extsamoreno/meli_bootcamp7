package com.desafio1.meli.exceptions;

import com.desafio1.meli.service.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(MainException.class)
    public ResponseEntity<ErrorDTO> handlerGlobalException(MainException mainException){
        return new ResponseEntity<>(mainException.getError(),mainException.getHttpStatus());
    }

}
