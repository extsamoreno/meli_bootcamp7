package com.meli.socialmeli.Service;

import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.exception.UserInvalidException;
import com.meli.socialmeli.model.UserMeli;

public interface IUserService {

    void follow(int userId, int userIdToFollow) throws UserInvalidException;
    UserMeli getFollowersList(int userId);
    UserResponseDTO getFollowers(Integer userId);
}
