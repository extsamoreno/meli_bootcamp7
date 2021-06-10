package com.SocialMeli.services;

import com.SocialMeli.dtos.*;
import com.SocialMeli.FollowerCountDTO;
import com.SocialMeli.exceptions.UnhandledException;
import com.SocialMeli.exceptions.UserException;
import com.SocialMeli.exceptions.UserIdFollowerEqualsFollowed;
import com.SocialMeli.exceptions.UserIdInvalidException;
import com.SocialMeli.exceptions.UserIdNotFoundException;

public interface IUserService {

    Boolean follow (Integer userID, Integer useridtofollow);
    void followUser(int userId, int userIdToFollow) throws UserException, UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException;
    public FollowersCountDTO getFollowersCountById(int userId) throws UserNotFoundException, UserIdNotFoundException;
    public FollowersListDTO getFollowersListById(int userId, String order) throws UserNotFoundException, UserIdNotFoundException;
    public FollowedListDTO getFollowedListById(int userId, String order) throws UserNotFoundException, UserIdNotFoundException;

}

