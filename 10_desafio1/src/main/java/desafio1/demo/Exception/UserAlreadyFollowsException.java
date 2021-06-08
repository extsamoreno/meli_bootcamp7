package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowsException extends ApiException {
    public UserAlreadyFollowsException(int userId, int userIdToFollow) {
        super("The User " + userId + " already follows User " + userIdToFollow, HttpStatus.BAD_REQUEST);
    }
}
