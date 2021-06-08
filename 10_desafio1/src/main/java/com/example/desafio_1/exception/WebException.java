package com.example.desafio_1.exception;

import com.example.desafio_1.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class WebException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public WebException(String message, HttpStatus status) {
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());

        this.status = status;
    }
}
