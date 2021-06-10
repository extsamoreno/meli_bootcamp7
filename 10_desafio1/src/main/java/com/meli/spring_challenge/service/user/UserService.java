package com.meli.spring_challenge.service.user;

import com.meli.spring_challenge.exception.user.UserFollowException;
import com.meli.spring_challenge.exception.user.UserNotFoundException;
import com.meli.spring_challenge.model.User;

import java.util.List;

public interface UserService {
    void followUser(int userID, int userIdToFollow) throws UserNotFoundException, UserFollowException;
    List<User> getAllUsers();
}
