package com.example.challenge.Services;

import com.example.challenge.Exceptions.UserNoFoundException;
import com.example.challenge.Services.DTOs.FollowDTO;
import com.example.challenge.Services.DTOs.FollowerCountDTO;
import com.example.challenge.Services.DTOs.FollowersDTO;
import com.example.challenge.Services.DTOs.GetUserDTO;

import java.util.List;

public interface IUserService {

    public FollowDTO follow(int follower, int followed) throws UserNoFoundException;

    public List<GetUserDTO> getUsers();

    public String addUser(String userName);

    public FollowerCountDTO getFollowersCont(int userId) throws UserNoFoundException;

    public FollowersDTO getFollowers(int userId) throws UserNoFoundException;

    public FollowersDTO getFollowed(int userId) throws UserNoFoundException;

    ;
}
