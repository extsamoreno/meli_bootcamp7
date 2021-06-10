package com.example.Challenge.exception;

import com.example.Challenge.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProgramException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public ProgramException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
