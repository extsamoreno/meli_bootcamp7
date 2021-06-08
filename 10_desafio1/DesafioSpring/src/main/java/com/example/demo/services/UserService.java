package com.example.demo.services;

import com.example.demo.dtos.UserFollowedListDTO;
import com.example.demo.dtos.UserFollowerListDTO;
import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyFollowException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void addUsers();
    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException;
    void unfollow(int userId, int userIdToFollow);
    UserFollowersCountDTO followersCount(int userId);
    UserFollowerListDTO getFollowersList(int userId);
    UserFollowedListDTO getFollowedList(int userId);
}
