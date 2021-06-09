package com.example.DesafioSpring.exceptions;

import com.example.DesafioSpring.dto.ErrorMsgDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ProductException extends Exception {
    private ErrorMsgDTO error;
    private HttpStatus status;

    public ProductException(String message, HttpStatus status){

        this.error = new ErrorMsgDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}
