package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowedByDTO;
import com.example.DesafioSpring.dto.FollowersDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;

import java.util.List;


public interface IUserService {
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException;
    public FollowDTO followSeller(int followerId, int followedId) throws UserNotFoundException;
    public FollowersCountDTO getFollowersCount(int userId) throws UserNotFoundException;
    public FollowersDTO getFollowers(int userid, String order) throws UserNotFoundException;
    public FollowedByDTO getFollowed(int userid, String order) throws UserNotFoundException;
    public List<User> getdb();
}
