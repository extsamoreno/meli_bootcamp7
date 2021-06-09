package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Follow;
import com.meli.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    User findUserById(Integer userId);
    void addFollower(User userTo, User userFrom);
    List<User> getUserFollowers(Integer userId, String order);
    List<User> getUserFollowed(Integer userId, String order);
    void deleteFollower(Integer userId, Integer userIdToUnfollow);
}
