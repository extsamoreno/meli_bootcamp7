package com.example.socialmeli.exceptions;

import com.example.socialmeli.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SocialException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public SocialException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
