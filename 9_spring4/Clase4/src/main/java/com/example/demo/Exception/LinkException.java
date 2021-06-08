package com.example.demo.Exception;

import com.example.demo.Model.DTO.DTOResponse.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception{
    ErrorDTO error = new ErrorDTO();
    HttpStatus status;

    public LinkException(String message, HttpStatus status) {
        error.setMessage(message);
        error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
