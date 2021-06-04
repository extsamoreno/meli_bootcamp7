package com.example.spring4.exceptions;

import com.example.spring4.dtos.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LinkException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}
