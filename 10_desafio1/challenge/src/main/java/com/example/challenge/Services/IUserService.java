package com.example.challenge.Services;

import com.example.challenge.Exceptions.*;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.*;

import java.util.List;

public interface IUserService {

    String loadUser() throws UserNotFoundException, PostDuplicateException;

    List<GetUserDTO> getUsers();

    String addUser(String userName);

    FollowDTO followUser(int follower, int followed) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException;

    FollowerCountDTO getFollowersCount(int userId) throws UserNotFoundException;

    FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException, InvalidOrderException;

    FollowersDTO getFollowed(int userId, String order) throws UserNotFoundException, InvalidOrderException;

    User getUserById(int userId) throws UserNotFoundException;

    FollowDTO unfollowUser(int followerId, int followedID) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException;

}
