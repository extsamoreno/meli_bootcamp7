package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.User;

public interface IUserRepository {
    public void addFollowerToUser(int userId,int userIdToFollow);
    public User getUserById(int userId) throws UserNotFoundException;
    public int getFollowersCount(int userId);
}
