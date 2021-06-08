package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.FollowCountDTO;
import com.example.SocialMeli.Services.DTOs.FollowDTO;
import com.example.SocialMeli.Services.DTOs.FollowedDTO;
import com.example.SocialMeli.Services.DTOs.FollowersDTO;

import java.util.List;

public interface iUserService {
    public FollowDTO follow(String follower, String followed) throws UserNotFoundException;
    public FollowCountDTO getFollowersCount(String userId) throws UserNotFoundException;
    public FollowersDTO getFollowers(String user_id) throws UserNotFoundException;
    public FollowedDTO getFollowed(String user_id) throws UserNotFoundException;
    public List<User> getdb();
}
