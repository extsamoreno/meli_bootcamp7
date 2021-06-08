package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.User;

public interface IUserRepository {
    public void addFollowerToUser(int userId,int userIdToFollow); //agregar seguidor
    public User getUserById(int userId) throws UserNotFoundException; //encontrar al user por id
    public int getFollowersCount(int userId); //contar seguidores
}
