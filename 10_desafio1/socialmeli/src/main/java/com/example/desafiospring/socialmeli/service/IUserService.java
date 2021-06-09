package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;

import java.util.Optional;

public interface IUserService {
    public void followUser(int userId , int userIdToFollow) throws UserNotFoundException;
    public void unFollowUser(int userId , int userIdToUnFollow) throws UserNotFoundException;
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;
    public UserDTO getUserFollowers(int userId) throws UserNotFoundException;
    public UserDTO getUserFollowed(int userId) throws UserNotFoundException;

    UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException;
}
