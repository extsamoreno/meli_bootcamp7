package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.FollowDTO;

import java.util.List;

public interface iUserService {
    public FollowDTO follow(String follower, String followed) throws UserNotFoundException;

    public List<User> getdb();
}
