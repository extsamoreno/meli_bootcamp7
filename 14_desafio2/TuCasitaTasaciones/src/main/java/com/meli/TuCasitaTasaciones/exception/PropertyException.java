package com.meli.TuCasitaTasaciones.exception;


import com.meli.TuCasitaTasaciones.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}