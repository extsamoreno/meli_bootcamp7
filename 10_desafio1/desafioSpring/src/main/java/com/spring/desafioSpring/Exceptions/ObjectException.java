package com.spring.desafioSpring.Exceptions;

import com.spring.desafioSpring.DTOs.*;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObjectException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public ObjectException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setType(this.getClass().getSimpleName());
        this.status = status;
    }

}
