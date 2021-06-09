package socialmeli.socialmeli.project.exceptions.UserExceptions;

import org.springframework.http.HttpStatus;

public class UnfollowException extends UserException{

    public UnfollowException(String userId){
        super("userId: "+userId+" was not being followed", HttpStatus.BAD_REQUEST);
    }
}
