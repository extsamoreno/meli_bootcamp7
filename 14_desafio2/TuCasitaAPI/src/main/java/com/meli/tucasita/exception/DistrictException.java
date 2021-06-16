package com.meli.tucasita.exception;

import com.meli.tucasita.service.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public DistrictException(String message, HttpStatus status){
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
