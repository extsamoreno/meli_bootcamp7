package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;

import java.util.Optional;

public interface IUserRepository {
    void followUser(int userId, int userIdToFollow) throws UserNotFoundException;

    void unFollowUser(int userId, int userIdToUnFollow) throws UserNotFoundException;

    UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;

    UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException;

    UserDTO getUserFollowed(int userId, Optional<String> order) throws UserNotFoundException;

    public void addFollowerToUser(int userId, int userIdToFollow); //agregar seguidor
    public User getUserById(int userId) throws UserNotFoundException; //encontrar al user por id, not found
    public int getFollowersCount(int userId); //contar seguidores
    public void insertPost(Post post) throws UserNotFoundException; //not found, cuando post
    public void removeFollowerToUser(int userId,int userIdToUnFollow) throws UserNotFoundException;

    Object findBy(Seller seller);
}
