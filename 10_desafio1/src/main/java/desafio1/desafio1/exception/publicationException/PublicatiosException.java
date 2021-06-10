package desafio1.desafio1.exception.publicationException;

import desafio1.desafio1.exception.userException.UserException;
import desafio1.desafio1.service.ErrorDTO;
import org.springframework.http.HttpStatus;

public class PublicatiosException extends UserException {

    public PublicatiosException(Integer id){
        super(new ErrorDTO("Error adding post", "The publication "+ id +" already exists"), HttpStatus.BAD_REQUEST);
    }

}
