package com.meli.desafio2.exception;

import com.meli.desafio2.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends RuntimeException{
    ErrorDTO error;
    HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
