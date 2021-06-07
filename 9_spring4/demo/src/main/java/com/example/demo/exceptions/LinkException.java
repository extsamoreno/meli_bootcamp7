package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LinkException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }


}
