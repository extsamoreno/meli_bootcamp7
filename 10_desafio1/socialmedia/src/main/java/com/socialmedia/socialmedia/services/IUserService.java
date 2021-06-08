package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.UserExistAsFollowerException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;

public interface IUserService {

    void followToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException;
}
