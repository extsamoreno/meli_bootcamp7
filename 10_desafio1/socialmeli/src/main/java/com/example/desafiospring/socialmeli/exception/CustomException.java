package com.example.desafiospring.socialmeli.exception;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public CustomException(String message,HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}