package bootcamp.cuatro.spring.exception;

import org.springframework.http.HttpStatus;

public class LInkUnavailableException extends LinkException{

    public LInkUnavailableException(Integer idLink) {
        super("el url con id: "+idLink+" no esta activo", HttpStatus.NOT_ACCEPTABLE);
    }
}
