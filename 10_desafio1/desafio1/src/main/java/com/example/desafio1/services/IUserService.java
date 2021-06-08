package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.models.User;

public interface IUserService {

    String createDB();
    User getUserById(int userId) throws InvalidUserIdException;
    String followUser(int userId, int userIdToFollow) throws InvalidUserIdException;
    ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException;
    ResponseFollowerListDTO getFollowers(int userId) throws InvalidUserIdException;
    ResponseFollowedSellerDTO getFollowedSellers(int userId) throws InvalidUserIdException;
}
