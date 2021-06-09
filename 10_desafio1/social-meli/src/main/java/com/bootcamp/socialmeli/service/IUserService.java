package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.UserAmountFollowersDTO;
import com.bootcamp.socialmeli.DTO.UserFollowedListDTO;
import com.bootcamp.socialmeli.DTO.UserFollowersListDTO;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {
    void follow(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException;

    List<User> getAllUsers();

    UserAmountFollowersDTO getAmountUserFollowers(Integer id) throws UserIdNotFoundException;

    UserFollowersListDTO getListUserFollowers(Integer id) throws UserIdNotFoundException;

    UserFollowedListDTO getListUserFollowed(Integer id) throws UserIdNotFoundException;

}
