package com.meli.demo.exceptions;

import com.meli.demo.dtos.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialExcepton extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public SocialExcepton(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
