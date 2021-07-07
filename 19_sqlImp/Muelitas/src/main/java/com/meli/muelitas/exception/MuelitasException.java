package com.meli.muelitas.exception;

import com.meli.muelitas.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MuelitasException extends RuntimeException{

    private final ErrorDTO error;
    private final HttpStatus status;

    public MuelitasException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
