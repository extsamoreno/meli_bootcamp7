package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowedByDTO;
import com.example.DesafioSpring.dto.FollowersDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;



public interface IUserService {
    public FollowedByDTO bringFollowedBy(int userId, String order) throws UserNotFoundException;
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException;
    public FollowDTO followSeller(int followerId, int followedId) throws UserNotFoundException;
    public FollowersCountDTO getFollowersCount(int userId) throws UserNotFoundException;
    public FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException;


}
