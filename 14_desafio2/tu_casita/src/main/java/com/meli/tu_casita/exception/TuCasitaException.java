package com.meli.tu_casita.exception;

import com.meli.tu_casita.model.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TuCasitaException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public TuCasitaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
