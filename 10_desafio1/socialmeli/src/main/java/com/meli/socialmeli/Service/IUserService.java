package com.meli.socialmeli.Service;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseCountDTO;
import com.meli.socialmeli.exception.UserInvalidException;
import com.meli.socialmeli.model.UserMeli;

public interface IUserService {

    void follow(int userId, int userIdToFollow) throws UserInvalidException;
    UserFollowerDTO getFollowersList(int userId);
    UserResponseCountDTO getFollowers(int userId);
}
