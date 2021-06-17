package com.example.desafiospring.socialmeli.exception;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

/**
 *exception the user, set message, error name and status
 */
public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message,HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }

    public UserException(ErrorDTO, HttpStatus.BAD_REQUEST) {
    }
}