package com.example.demo.project.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductException  extends  Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public ProductException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
