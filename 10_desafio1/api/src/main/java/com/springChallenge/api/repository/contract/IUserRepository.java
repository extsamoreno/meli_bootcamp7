package com.springChallenge.api.repository.contract;

import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.entity.Post;
import com.springChallenge.api.repository.entity.User;

import java.util.ArrayList;

public interface IUserRepository {
    User getByUserId(int userId) throws UserNotFoundException;

    void save(User user);

    ArrayList<Post> getFollowedPosts(int userId) throws UserNotFoundException;

    ArrayList<Post> getPromoPostsById(Integer userId) throws UserNotFoundException;
}
