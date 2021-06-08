package com.example.SocialMeli.Exceptions;

import com.example.SocialMeli.Services.DTOs.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status){

        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
