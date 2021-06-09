package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.model.User;

public interface IUserRepository {
    public void addFollowerToUser(int userId,int userIdToFollow); //agregar seguidor
    public User getUserById(int userId) throws UserNotFoundException; //encontrar al user por id, not found
    public int getFollowersCount(int userId); //contar seguidores
    public void insertPost(Post post) throws UserNotFoundException; //not found, cuando post
    public void removeFollowerToUser(int userId,int userIdToUnFollow) throws UserNotFoundException;
}
