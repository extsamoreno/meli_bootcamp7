package com.digitalhouse.obtenerdiploma.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObtenerDiplomaException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
