package com.meli.linktracker.exception;

import com.meli.linktracker.service.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status){
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
