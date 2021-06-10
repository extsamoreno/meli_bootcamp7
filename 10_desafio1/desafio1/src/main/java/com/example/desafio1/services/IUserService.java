package com.example.desafio1.services;

import com.example.desafio1.dtos.FollowedDTO;
import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.FollowersDTO;
import com.example.desafio1.exceptions.*;

public interface IUserService {
    void processNewFollowing(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingAlreadyExistsException, RepeatedUsersIdException;

    FollowersCountDTO getFollowersCount(int userId) throws OrderNotValidException;

    FollowersDTO getFollowers(int userId, String order) throws OrderNotValidException;

    FollowedDTO getFollowed(int userId, String order) throws OrderNotValidException;

    void processUnfollow(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingDoesNotExistException;
}
