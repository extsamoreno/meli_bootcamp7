package com.tucasitatasaciones.demo.exception;

import com.tucasitatasaciones.demo.dto.ErrorDTO;
import lombok.*;
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
