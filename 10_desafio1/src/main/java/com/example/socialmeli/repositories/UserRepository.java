package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowersResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserDTO addUser(NewUserRequestDTO newUser) throws ExistentUserException;
    void followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException;
    User getUserById (int userId) throws InexistentUserException;
    List<UserDTO> getUsers();
    FollowersCountResponseDTO countResponse(int userId) throws InexistentUserException;
    ListFollowersResponseDTO listFollowers(int userId) throws InexistentUserException;
    ListFollowedResponseDTO listFollowed (int userId) throws InexistentUserException;
    void unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException;
}
