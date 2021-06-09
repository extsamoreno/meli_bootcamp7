package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.FollowDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;

import java.util.ArrayList;


public interface IUserService {
    FollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException;

    UserFollowerCount getFollowerCount(int userId);

    UserFollowerListDTO getFollowerList(int userId);

}
