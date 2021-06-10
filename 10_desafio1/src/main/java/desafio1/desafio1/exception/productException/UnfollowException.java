package desafio1.desafio1.exception.productException;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UserException;
import desafio1.desafio1.service.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UnfollowException extends UserException {

    public UnfollowException(int userToUnfollowId){
        super(new ErrorDTO("User Not Found", "You cannot unfollow the user:  "+userToUnfollowId), HttpStatus.BAD_REQUEST);
    }
}
