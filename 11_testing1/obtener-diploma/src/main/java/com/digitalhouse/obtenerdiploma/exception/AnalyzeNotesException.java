package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AnalyzeNotesException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public AnalyzeNotesException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
