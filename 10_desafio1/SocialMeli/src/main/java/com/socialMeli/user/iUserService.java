package com.socialMeli.user;

import com.socialMeli.user.exceptions.UserNotFoundException;
import com.socialMeli.user.models.FollowersCountDTO;
import com.socialMeli.user.models.FollowListDTO;

public interface iUserService {

    Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException;
    FollowersCountDTO countFollowers (Integer userId) throws UserNotFoundException;
    FollowListDTO listFollowers (Integer userId) throws UserNotFoundException;
    FollowListDTO listFollowed (Integer userId) throws UserNotFoundException;
}
