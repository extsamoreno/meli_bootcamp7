package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;

import java.util.List;

public interface IUserService {

    String createDB();
    User getUserById(int userId) throws InvalidUserIdException;
    String followUser(int userId, int userIdToFollow) throws UserException;
    String unfollowUser(int userId, int userIdToUnfollow) throws UserException;
    ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException;
    ResponseFollowerListDTO getFollowersList(int userId, String order) throws UserException;
    ResponseFollowedSellerDTO getFollowedSellers(int userId, String order) throws UserException;
    List<UserDTO> getFollowedList(int userId) throws InvalidUserIdException;
    List<Post> getPostsList(int userId) throws InvalidUserIdException;
}
