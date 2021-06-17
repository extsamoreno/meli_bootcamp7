package meli.bootcamp.tucasita.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public class PropertyNotFoundException extends PropertyException{

    public PropertyNotFoundException(String name) {
        super("La propiedad con nombre "+name+" no se encuentra registrada.", HttpStatus.BAD_REQUEST);
    }
}
