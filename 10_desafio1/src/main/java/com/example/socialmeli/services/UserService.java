package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    NewUserResponseDTO addUser(NewUserRequestDTO newUserRequestDTO) throws ExistentUserException;
    FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException;
    FollowersCountResponseDTO countFollowers(int userId) throws InexistentUserException;
    ListFollowersResponseDTO listFollowers(int userId, String order) throws InexistentUserException, InexistentOrderException;
    ListFollowedResponseDTO listFollowed (int userId, String order) throws InexistentUserException, InexistentOrderException;
    FollowSellerResponseDTO unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException;
}
