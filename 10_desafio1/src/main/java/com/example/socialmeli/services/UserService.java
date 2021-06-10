package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    NewUserResponseDTO addUser(NewUserRequestDTO newUserRequestDTO) throws ExistentUserException, InvalidUserException;
    FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException, InvalidFollowerException;
    FollowersCountResponseDTO countFollowers(int userId) throws InexistentUserException;
    ListFollowersResponseDTO listFollowers(int userId, String order) throws InexistentUserException, InexistentNameOrderException;
    ListFollowedResponseDTO listFollowed (int userId, String order) throws InexistentUserException, InexistentNameOrderException;
    FollowSellerResponseDTO unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException;
}
