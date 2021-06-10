package desafio1.desafio1.exception.userException;

import desafio1.desafio1.service.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FollowLoopException extends UserException {

    public FollowLoopException(){
        super(new ErrorDTO("Follow error", "Can't follow himself"), HttpStatus.BAD_REQUEST);
    }
}
