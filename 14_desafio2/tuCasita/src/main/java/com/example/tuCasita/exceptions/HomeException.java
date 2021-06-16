package com.example.tuCasita.exceptions;

import com.example.tuCasita.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HomeException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public HomeException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
