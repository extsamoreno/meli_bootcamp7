package com.meli.desafio2.exception;

import com.meli.desafio2.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
