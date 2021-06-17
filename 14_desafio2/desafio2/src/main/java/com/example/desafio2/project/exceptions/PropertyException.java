package com.example.desafio2.project.exceptions;

import com.example.desafio2.project.services.Dto.ErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends Exception {
    private ErrorDto error;
    private HttpStatus status;

    public PropertyException (String message, HttpStatus status){
        this.error = new ErrorDto();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }

}
