package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.models.User;
import com.example.desafio1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String createDB() {
        return iUserRepository.createDB();
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        return iUserRepository.getUserById(userId);
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws InvalidUserIdException {
        return iUserRepository.followUser(userId, userIdToFollow);
    }

    @Override
    public ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        return iUserRepository.getFollowersCount(userId);
    }

    @Override
    public ResponseFollowerListDTO getFollowers(int userId) throws InvalidUserIdException {
        return iUserRepository.getFollowers(userId);
    }

    @Override
    public ResponseFollowedSellerDTO getFollowedSellers(int userId) throws InvalidUserIdException {
        return iUserRepository.getFollowedSellers(userId);
    }
}
