package com.meli.socialmeli.repository;

import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.model.UserMeli;

public interface IUserRepository {
    void follow(int userId, int userIdToFollow);

    //void save(int userId, String userName);

    void saveUser(int userId, String userName);

    UserMeli ListUser(int userId);

    UserResponseDTO getFollowersById(Integer userId);

}
