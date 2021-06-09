package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.exceptions.UserNotFoundException;


public interface IUserService {
    UserFollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException;

    UserFollowerCount getFollowerCount(int userId);

    UserFollowerListDTO getFollowerList(int userId);

    UserFollowedByListDTO getFollowedBy(int userId);

    UserFollowDTO unfollow(int userId, int userIdToUnfollow) throws UserInvalidException, UserNotFoundException;

}
