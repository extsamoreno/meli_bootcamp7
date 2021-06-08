package com.example.challenge.Services;

import com.example.challenge.Exceptions.UserNoFoundException;
import com.example.challenge.Models.User;
import com.example.challenge.Repositories.IUserRepository;
import com.example.challenge.Services.DTOs.FollowDTO;
import com.example.challenge.Services.DTOs.FollowerCountDTO;
import com.example.challenge.Services.DTOs.FollowersDTO;
import com.example.challenge.Services.DTOs.GetUserDTO;
import com.example.challenge.Services.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    UserMapper um = new UserMapper();

    @Override
    public FollowDTO follow(int follower, int followed) throws UserNoFoundException {
        return iUserRepository.follow(follower, followed);
    }

    public List<GetUserDTO> getUsers() {
        List<GetUserDTO> res = new ArrayList<>();
        for (User u : iUserRepository.getUsers()) {
            res.add(um.userToGetUser(u));
        }
        return res;
    }

    @Override
    public String addUser(String userName) {
        return iUserRepository.addUser(userName);
    }

    @Override
    public FollowerCountDTO getFollowersCont(int userId) throws UserNoFoundException {
        User u = iUserRepository.findUserByID(userId);
        return um.userToFollowerCount(u);
    }

    @Override
    public FollowersDTO getFollowers(int userId) throws UserNoFoundException {
        User u = iUserRepository.findUserByID(userId);
        return um.userToFollowers(u);
    }

    @Override
    public FollowersDTO getFollowed(int userId) throws UserNoFoundException {
        User u = iUserRepository.findUserByID(userId);
        return um.userToFollowed(u);
    }
}