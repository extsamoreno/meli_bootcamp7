package com.example.AppConsultorioMySQL.Exceptions;

import com.example.AppConsultorioMySQL.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ConsultoryException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public ConsultoryException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
