package com.example.desafio2.exception;

import com.example.desafio2.service.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class NeighborhoodException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;
    public NeighborhoodException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}