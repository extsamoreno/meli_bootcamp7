package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.PostDuplicateException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowDTO;

import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

     String addUser(String userName);

     FollowDTO follow(int follower, int followed) throws UserNotFoundException;

     List<User> getUsers();

     User findUserById(int userId) throws UserNotFoundException;

     void loadData() throws UserNotFoundException, PostDuplicateException;

     void addPost(Post post) throws UserNotFoundException, PostDuplicateException;

    FollowDTO unfollow(int follower, int followed) throws UserNotFoundException;
}
