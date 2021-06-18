package com.meli.desafio2.exception;

import com.meli.desafio2.model.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PropertyException extends Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public PropertyException(String message, HttpStatus status){
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
