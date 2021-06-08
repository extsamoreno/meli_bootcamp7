package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.User;

public interface UserRepository {
    public void addFollowerToUser(int userId,int userIdToFollow);
    public User getUserById(int userId) throws UserNotFoundException;
    public int getFollowersCount(int userId);
}
