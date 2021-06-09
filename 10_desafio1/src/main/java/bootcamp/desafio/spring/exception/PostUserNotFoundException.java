package bootcamp.desafio.spring.exception;

import org.springframework.http.HttpStatus;

public class PostUserNotFoundException extends PostException{

    public PostUserNotFoundException(Long userId) {
        super("No se puede crear el post debido a que el usurio con id: "+userId+" no existe.", HttpStatus.NOT_FOUND);;
    }
}
