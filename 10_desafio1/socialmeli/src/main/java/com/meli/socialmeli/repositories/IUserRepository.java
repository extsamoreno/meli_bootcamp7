package com.meli.socialmeli.repositories;

import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.exceptions.UserNotFoundException;
import com.meli.socialmeli.models.UserMeli;

import java.util.ArrayList;

public interface IUserRepository {
    UserMeli followMerchant(int userId, int userIdToFollow) throws UserInvalidException;
    UserMeli getFollowerCountById(int userId);
    UserMeli getFollowerListById(int userId);

    UserResponseDTO getFollowerById(int userId);

    ArrayList<UserResponseDTO> getFollowersById(int userId);

    UserFollowerListDTO getListFollowersById(int userId);

    UserFollowedByListDTO getListFollowedById(int userId);

    UserMeli unfollowMerchant(int userId, int userIdToFollow) throws UserNotFoundException;
}
