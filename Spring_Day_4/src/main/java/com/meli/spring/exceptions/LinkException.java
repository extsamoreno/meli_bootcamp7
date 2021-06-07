package com.meli.spring.exceptions;

import com.meli.spring.services.dto.ErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception{
    private ErrorDto error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status){
        this.error = new ErrorDto();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
