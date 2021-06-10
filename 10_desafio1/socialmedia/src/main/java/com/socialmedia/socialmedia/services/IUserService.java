package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;

public interface IUserService {

    void followToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException, ObjectNotFoundException, UserDistinctTypeException;
    void unfollowToUser(int userId, int userIdToFollow) throws UserNotFoundException, ObjectNotFoundException, UserNotExistAsFollowerException;
    UserCountFollowerDTO getCountFollowersByUser(int userId) throws ObjectNotFoundException, UserDistinctTypeException;
    UserWithFollowersDTO getFollowersByUser(int userId, String order) throws ObjectNotFoundException, UserDistinctTypeException;
    UserWithFollowedDTO getFollowedByUser(int userId, String order) throws ObjectNotFoundException, UserDistinctTypeException;
}
