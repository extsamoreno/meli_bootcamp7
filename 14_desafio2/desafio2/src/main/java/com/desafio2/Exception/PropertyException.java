package com.desafio2.Exception;

import com.desafio2.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;

public class PropertyException extends RuntimeException{
    private final ErrorDTO error;
    private final HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}