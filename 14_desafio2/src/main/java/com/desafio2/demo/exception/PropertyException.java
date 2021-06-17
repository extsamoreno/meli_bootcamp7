package com.desafio2.demo.exception;

import com.desafio2.demo.dtos.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PropertyException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}