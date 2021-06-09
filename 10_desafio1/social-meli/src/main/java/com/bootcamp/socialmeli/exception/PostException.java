package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostException extends Exception{

    private ErrorDTO error;
    private HttpStatus httpStatus;

    public PostException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.httpStatus = status;
    }
}
