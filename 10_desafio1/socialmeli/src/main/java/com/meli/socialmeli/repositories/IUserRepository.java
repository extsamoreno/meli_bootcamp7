package com.meli.socialmeli.repositories;

import com.meli.socialmeli.dto.FollowDTO;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.models.UserMeli;

import java.util.ArrayList;

public interface IUserRepository {
    UserMeli followMerchant(int userId, int userIdToFollow);
    UserMeli getFollowerCountById(int userId);
    UserMeli getFollowerListById(int userId);

    UserResponseDTO getFollowerById(int userId);

    ArrayList<UserResponseDTO> getFollowersById(int userId);

    UserFollowerListDTO getListFolloweraById(int userId);
}
