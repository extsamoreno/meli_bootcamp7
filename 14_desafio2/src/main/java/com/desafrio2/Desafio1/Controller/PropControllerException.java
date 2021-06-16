package com.desafrio2.Desafio1.Controller;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.ErrorDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropControllerException {

    @ExceptionHandler(DistrictNotExist.class)
    public ResponseEntity<ErrorDTO> handlerException(DistrictNotExist e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
