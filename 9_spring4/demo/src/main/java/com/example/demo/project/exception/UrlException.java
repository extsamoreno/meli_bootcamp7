package com.example.demo.project.exception;

import com.example.demo.project.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UrlException extends  Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public UrlException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}