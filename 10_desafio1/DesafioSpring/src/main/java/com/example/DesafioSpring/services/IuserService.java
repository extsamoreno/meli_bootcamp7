package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;

import java.util.List;


public interface IuserService {
    public FollowDTO followSeller(String follower, String followed) throws UserNotFoundException;
    public FollowersCountDTO getFollowersCount(String userId) throws UserNotFoundException;

    public List<User> getDatabase();
}
