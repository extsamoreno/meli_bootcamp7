package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserDoesNotFollowException extends ApiException{
    public UserDoesNotFollowException(int userId, int userIdToUnfollow) {
        super("User ID:"+userId+" doesn't follow user ID:" + userIdToUnfollow, HttpStatus.BAD_REQUEST);
    }
}
