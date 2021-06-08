package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.FollowDTO;

import java.util.List;

public interface iUserRepository {

    public FollowDTO follow(String follower, String followed) throws UserNotFoundException;
    public List<User> getUsers();
}
