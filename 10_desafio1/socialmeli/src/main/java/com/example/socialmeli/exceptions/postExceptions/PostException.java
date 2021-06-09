package com.example.socialmeli.exceptions.postExceptions;

import com.example.socialmeli.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public PostException(String message, HttpStatus status) {
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
