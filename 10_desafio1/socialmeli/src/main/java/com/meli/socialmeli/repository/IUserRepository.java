package com.meli.socialmeli.repository;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseCountDTO;
import com.meli.socialmeli.model.UserMeli;

public interface IUserRepository {
    void follow(int userId, int userIdToFollow);

    //void save(int userId, String userName);

    void saveUser(int userId, String userName);

    UserFollowerDTO ListUser(int userId);

    UserResponseCountDTO getFollowersById(int userId);

}
