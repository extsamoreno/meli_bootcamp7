package com.example.ejerciciointegradorapi.project.exceptions;


import com.example.ejerciciointegradorapi.project.services.Dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkTrackerException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public LinkTrackerException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
}

}

