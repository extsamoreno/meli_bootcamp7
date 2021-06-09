package socialmeli.socialmeli.project.exceptions.UserExceptions;

import org.springframework.http.HttpStatus;

public class FollowMyselfException extends UserException {
    public FollowMyselfException(String id) {
        super("Error: You can't follow yourself", HttpStatus.BAD_REQUEST);
    }

}
