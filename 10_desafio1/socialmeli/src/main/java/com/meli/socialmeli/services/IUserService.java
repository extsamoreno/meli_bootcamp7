package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.*;


public interface IUserService {
    UserFollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException, UserItselfException, UserIsNotMerchant, UserDoNotExistsException;

    UserFollowerCount getFollowerCount(int userId);

    UserFollowerListDTO getFollowerList(int userId, String order);

    UserFollowedByListDTO getFollowedBy(int userId, String order);

    UserFollowDTO unfollow(int userId, int userIdToUnfollow) throws UserInvalidException, UserNotFoundException;

}
