package com.socialmedia.socialmedia.repositories;

import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.User;

public interface IUserRepository {
    int followToUser(int userId, int userIdToFollow);
    User getUserById(int userId) throws UserNotFoundException;
}
