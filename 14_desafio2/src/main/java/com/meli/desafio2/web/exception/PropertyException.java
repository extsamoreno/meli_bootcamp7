package com.meli.desafio2.web.exception;

import com.meli.desafio2.web.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
@Getter
public class PropertyException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException(Map<String,String> message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessages(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
