package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.PostDuplicateException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowDTO;

import java.util.List;

public interface IUserRepository {

    List<User> getUsers();

    void loadData() throws UserNotFoundException, PostDuplicateException;

    User findUserById(int userId) throws UserNotFoundException;

    FollowDTO follow(int follower, int followed) throws UserNotFoundException;

    FollowDTO unfollow(int follower, int followed) throws UserNotFoundException;

    void addPost(Post post) throws UserNotFoundException, PostDuplicateException;


}
