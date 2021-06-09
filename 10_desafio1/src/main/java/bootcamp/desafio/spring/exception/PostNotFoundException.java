package bootcamp.desafio.spring.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends PostException{

    public PostNotFoundException(Long idPost) {
        super("El post con id: "+idPost+" no se encuentra registrado", HttpStatus.NOT_FOUND);
    }
}
