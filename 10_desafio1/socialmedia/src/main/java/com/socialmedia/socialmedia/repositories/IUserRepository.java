package com.socialmedia.socialmedia.repositories;

import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.User;

import java.util.List;

public interface IUserRepository {
    int followToUser(int userId, int userIdToFollow);
    User getUserById(int userId) throws UserNotFoundException;
    List<User> getFollowersByUser(int userId) throws UserNotFoundException;
    List<User> getFollowedByUser(int id) throws UserNotFoundException;
}
