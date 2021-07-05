package com.muelitas.demo.exceptions;

import com.muelitas.demo.dtos.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public BadRequestException(String message){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = HttpStatus.BAD_REQUEST;
    }
}
