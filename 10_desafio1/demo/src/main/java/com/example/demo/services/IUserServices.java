package com.example.demo.services;

import com.example.demo.model.DTO.FollowersListDTO;
import com.example.demo.model.DTO.ResponseCountDTO;

public interface IUserServices {

    public boolean followUser(int userId, int userIdToFollow);

    public ResponseCountDTO getFollowersCount(int userId);

    public FollowersListDTO getFollowersList(int userId);
}
