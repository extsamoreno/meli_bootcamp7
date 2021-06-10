package com.example.desafio1.service.user;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.service.dto.userdto.FollowedListDTO;
import com.example.desafio1.service.dto.userdto.FollowersCountDTO;
import com.example.desafio1.service.dto.userdto.FollowersListDTO;

import java.util.ArrayList;

public interface IUserService {
    String followUser(int userId, int userIdToFollow) throws UserNotFoundException;
    ArrayList<User> getUsersList();
    FollowersCountDTO getFollowersCountDTO(int userId) throws UserNotFoundException;
    FollowersListDTO getFollowersListDTO(int userId, String order) throws UserNotFoundException;
    FollowedListDTO getFollowedListDTO(int userId, String order) throws UserNotFoundException;

    String unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException;
}
