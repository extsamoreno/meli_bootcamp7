package bootcamp.cuatro.spring.exception;

import org.springframework.http.HttpStatus;

public class LinkMalformedSyntaxException extends LinkException{

    public LinkMalformedSyntaxException(Integer linkId) {
        super("El url con id: "+linkId+" no contiene un URL valido por lo tanto se desactivara", HttpStatus.BAD_REQUEST);
    }
}
