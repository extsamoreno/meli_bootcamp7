package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.UserExistAsFollowerException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;

public interface IUserService {

    void followToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException;
    void unfollowToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException;
    UserCountFollowerDTO getCountFollowersByUser(int userId) throws UserNotFoundException;
    UserWithFollowersDTO getFollowersByUser(int userId) throws UserNotFoundException;
    UserWithFollowedDTO getFollowedByUser(int userId) throws UserNotFoundException;
}
