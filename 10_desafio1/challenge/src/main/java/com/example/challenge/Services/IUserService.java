package com.example.challenge.Services;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.UserAlreadyFollowException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Exceptions.UserSameIdException;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.*;

import java.util.List;

public interface IUserService {

    String loadUser();

    List<GetUserDTO> getUsers();

    String addUser(String userName);

    FollowDTO followUser(int follower, int followed) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException;

    FollowerCountDTO getFollowersCount(int userId) throws UserNotFoundException;

    FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException, InvalidOrderException;

    FollowersDTO getFollowed(int userId, String order) throws UserNotFoundException, InvalidOrderException;

    User getUserById(int userId) throws UserNotFoundException;

    FollowDTO unfollowUser(int followerId, int followedID)throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException;

}
