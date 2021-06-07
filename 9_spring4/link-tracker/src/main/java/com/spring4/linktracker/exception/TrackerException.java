package com.spring4.linktracker.exception;

import com.spring4.linktracker.service.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TrackerException extends  Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public TrackerException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
