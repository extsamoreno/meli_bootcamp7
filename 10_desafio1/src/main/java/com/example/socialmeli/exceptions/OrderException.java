package com.example.socialmeli.exceptions;

import com.example.socialmeli.models.dtos.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class OrderException extends Exception{
    private ErrorDTO error;
    private HttpStatus httpStatus;

    public OrderException(String message, HttpStatus httpStatus) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setError(this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }
}
