package socialmeli.socialmeli.project.exceptions;

import org.springframework.http.HttpStatus;

public class FollowAlreadyException extends UserException{
    public FollowAlreadyException(String id) {
        super("Error: You have already followed user: "+id, HttpStatus.BAD_REQUEST);
    }

}
