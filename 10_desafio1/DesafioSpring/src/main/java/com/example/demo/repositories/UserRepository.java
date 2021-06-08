package com.example.demo.repositories;

import com.example.demo.dtos.UserFollowedListDTO;
import com.example.demo.dtos.UserFollowerListDTO;
import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyFollowException;

public interface UserRepository {

    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException;
    void unfollow(int userId, int userIdToUnfollow);
    UserFollowersCountDTO followersCount(int userId);
    UserFollowerListDTO followersList(int userId);
    UserFollowedListDTO followedList(int userId);
}
