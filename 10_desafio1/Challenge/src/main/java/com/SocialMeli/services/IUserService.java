package com.SocialMeli.services;

import com.SocialMeli.dtos.*;
import com.SocialMeli.dtos.FollowersCountDTO;
import com.SocialMeli.exceptions.UserIdNotFoundException;

public interface IUserService {

    Boolean follow (Integer userId, Integer userIdToFollow);
    FollowersCountDTO getFollowersCountById(Integer userId) throws UserIdNotFoundException, UserIdNotFoundException;
    FollowersListDTO getFollowersListById(Integer userId, String order) throws UserIdNotFoundException, UserIdNotFoundException;
    FollowedListDTO getFollowedListById(Integer userId, String order) throws UserIdNotFoundException, UserIdNotFoundException;
    FollowersListDTO getFollowing(Integer id);
}

