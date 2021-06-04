package bootcamp.cuatro.spring.exception;

import org.springframework.http.HttpStatus;


public class LinkNotFoundException extends LinkException{

    public LinkNotFoundException(Integer linkId) {
        super("El id: "+linkId+" no corresponde a ningun Product", HttpStatus.BAD_REQUEST);
    }
}
