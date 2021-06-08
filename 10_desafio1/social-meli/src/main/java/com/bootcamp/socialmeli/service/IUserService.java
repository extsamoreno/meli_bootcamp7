package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.UserAmountFollowersDTO;
import com.bootcamp.socialmeli.DTO.UserFollowedListDTO;
import com.bootcamp.socialmeli.DTO.UserFollowersListDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {
    void follow(Integer userId, Integer userIdToFollow);

    List<User> getAllUsers();

    UserAmountFollowersDTO getAmountUserFollowers(Integer id);

    UserFollowersListDTO getListUserFollowers(Integer id);

    UserFollowedListDTO getListUserFollowed(Integer id);

}
