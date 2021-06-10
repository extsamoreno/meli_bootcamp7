package com.example.demo.services;

import com.example.demo.model.DTO.FollowedListDTO;
import com.example.demo.model.DTO.FollowersListDTO;
import com.example.demo.model.DTO.ResponseCountDTO;

public interface IUserServices {

    boolean followUser(int userId, int userIdToFollow);

    ResponseCountDTO getFollowersCount(int userId);

    FollowersListDTO getFollowersList(int userId);

    FollowedListDTO getFollowedList(int userId);

    boolean unfollow(int userId, int userIdToUnfollow);

    FollowersListDTO getOrderedFollowersList(int userId, String order);

    FollowedListDTO getOrderedFollowedList(int userId, String order);

}
