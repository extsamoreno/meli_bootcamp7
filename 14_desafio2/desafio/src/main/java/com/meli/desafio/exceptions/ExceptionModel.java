package com.meli.desafio.exceptions;

import com.meli.desafio.exceptions.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ExceptionModel extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public ExceptionModel(String message, HttpStatus status){
        this.error = ErrorDTO.builder()
                .message(message)
                .name(this.getClass().getSimpleName())
                .build();

        this.status = status;
    }
}
