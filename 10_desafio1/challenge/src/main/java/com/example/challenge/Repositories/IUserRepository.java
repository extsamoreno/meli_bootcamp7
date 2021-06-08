package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.UserNoFoundException;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowDTO;

import java.util.List;

public interface IUserRepository {

    public String addUser(String userName);

    public FollowDTO follow(int follower, int followed) throws UserNoFoundException;

    public List<User> getUsers();

    public User findUserByID(int userId) throws UserNoFoundException;

}
