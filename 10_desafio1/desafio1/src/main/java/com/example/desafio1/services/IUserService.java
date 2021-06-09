package com.example.desafio1.services;

import com.example.desafio1.dtos.FollowedDTO;
import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.FollowersDTO;
import com.example.desafio1.exceptions.FollowingAlreadyExistsException;
import com.example.desafio1.exceptions.FollowingDoesNotExistException;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.exceptions.UserIdNotValidException;

public interface IUserService {
    void processNewFollowing(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingAlreadyExistsException;
    FollowersCountDTO getFollowersCount(int userId);
    FollowersDTO getFollowers(int userId, String order) throws OrderNotValidException;
    FollowedDTO getFollowed(int userId, String order) throws OrderNotValidException;
    void processUnfollow(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingDoesNotExistException;
}
