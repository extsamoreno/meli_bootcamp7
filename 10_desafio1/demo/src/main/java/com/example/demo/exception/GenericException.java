package com.example.demo.exception;

import com.example.demo.DTO.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public GenericException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;

    }
}
