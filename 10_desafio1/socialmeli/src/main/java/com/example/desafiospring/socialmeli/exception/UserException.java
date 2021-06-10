package com.example.desafiospring.socialmeli.exception;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message,HttpStatus status){
        this.error = new ErrorDTO(); //error
        this.error.setMessage(message); //seteo mensaje
        this.error.setName(this.getClass().getSimpleName()); //error name
        this.status = status; //el status
    }

    public UserException(ErrorDTO errorDTO, HttpStatus badRequest) {
    }
}
//lo dejo por las dudas