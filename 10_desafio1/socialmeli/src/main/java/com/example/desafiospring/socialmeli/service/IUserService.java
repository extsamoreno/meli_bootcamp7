package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Optional;

public interface IUserService {
    static Object PostList(Integer sellerId) {
    }

    Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException;
    UserFollowDTO countFollowers (Integer userId) throws UserNotFoundException;
    UserFollowDTO listFollowers (Integer userId) throws UserNotFoundException;
    UserFollowDTO listFollowed (Integer userId) throws UserNotFoundException;
    Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;
    static Seller orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongMethodTypeException;
    Seller orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongMethodTypeException;
    static User orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongMethodTypeException;
    User orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongMethodTypeException;
    static void followUser(int userId, int userIdToFollow) throws UserNotFoundException;
    void followUser(int userId, int userIdToFollow) throws UserNotFoundException;
    static void unFollowUser(int userId, int userIdToUnFollow) throws UserNotFoundException;
    void unFollowUser(int userId, int userIdToUnFollow) throws UserNotFoundException;
    static UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;
    UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;
    static UserDTO getUserFollowers(int userId) throws UserNotFoundException {
        return null;
    }
    UserDTO getUserFollowers(int userId) throws UserNotFoundException;
    static UserDTO getUserFollowed(int userId) throws UserNotFoundException;
    UserDTO getUserFollowed(int userId) throws UserNotFoundException;
    UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException //ordenamiento por fechas ascendente y descendente
    ;
    UserDTO getUserFollowed(int userId, Optional<String> order) throws UserNotFoundException;
}
