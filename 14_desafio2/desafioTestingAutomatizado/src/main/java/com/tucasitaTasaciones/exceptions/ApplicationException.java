package com.tucasitaTasaciones.exceptions;

import com.tucasitaTasaciones.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationException extends RuntimeException {
    private final ErrorDTO error;
    private final HttpStatus status;

    public ApplicationException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}