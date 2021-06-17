package com.meli.desafio2.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyNotFoundException extends PropertyException{
    public PropertyNotFoundException() {
        super("The ID does not correspond to any registered property.", HttpStatus.NOT_FOUND);
    }
}
