package meli.springchallenge.repositories;

import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.User;

import java.util.List;

public interface IUserRepository {

    void addFollower(int follower, int following) throws UserNotValidException, RelationNotValidException;

    int removeFollower(int userId, int userIdToUnfollow);

    User getUserById (int userId) throws UserNotValidException;

    int countFollowers(int userId);

    List<User> getFollowers(int userId);

    List<User> getFollowed(int userId);

    boolean validateUser( int userId) throws UserNotValidException;

}
