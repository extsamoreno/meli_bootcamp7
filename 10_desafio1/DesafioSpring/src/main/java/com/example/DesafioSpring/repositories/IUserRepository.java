package com.example.DesafioSpring.repositories;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;

import java.util.List;

public interface IUserRepository {
    public FollowDTO followSeller(String follower, String followed) throws UserNotFoundException;
    public List<User> getUsers();

    public FollowersCountDTO getFollowersCount(String userId)throws UserNotFoundException;
}
