package com.example.LinkTracker.exception;
import com.example.LinkTracker.service.DTOs.Response.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
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