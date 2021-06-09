package com.desafiospring.socialMeli.service;


import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserAlreadyFollowsException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;


public interface IUserService {

    void followSeller (int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException;

    FollowersCountDTO getNumberOfFollowers(int userId) throws UserNotFoundException;

    UserFollowedDTO getFollowers(int userId) throws UserNotFoundException;

    UserFollowingDTO getFollowingList(int userId) throws UserNotFoundException;

    void unfollowSeller (int userId, int userIdToFollow) throws UserNotFoundException;
}
