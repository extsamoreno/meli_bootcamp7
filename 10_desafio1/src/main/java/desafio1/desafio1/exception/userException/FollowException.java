package desafio1.desafio1.exception.userException;

import desafio1.desafio1.service.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FollowException extends UserException {

    public FollowException(int userToUnfollowId){
        super(new ErrorDTO("Follow error", "Already follow this user:  "+userToUnfollowId), HttpStatus.BAD_REQUEST);
    }
}
