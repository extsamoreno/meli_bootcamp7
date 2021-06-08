package com.example.desafio1.service;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.service.dto.userdto.FollowedListDTO;
import com.example.desafio1.service.dto.userdto.FollowersCountDTO;
import com.example.desafio1.service.dto.userdto.FollowersListDTO;

import java.util.ArrayList;

public interface IUserService {
    String followUser(int userId, int userIdToFollow) throws UserNotFoundException;
    void follow(User user, User userTofollow);
    void addFollower(User user, User follower);
    void addFollowed(User user, User followed);
    ArrayList<User> getUsersList();
    FollowersCountDTO getFollowersCountDTO(int userId) throws UserNotFoundException;
    FollowersListDTO getFollowersListDTO(int userId) throws UserNotFoundException;
    FollowedListDTO getFollowedListDTO(int userId) throws UserNotFoundException;

}
