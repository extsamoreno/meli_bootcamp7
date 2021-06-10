package com.meli.socialmeli.repository.user;

import com.meli.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    User findUserById(Integer userId);
    boolean addFollower(User userTo, User userFrom);
    List<User> getUserFollowers(Integer userId, String order);
    List<User> getUserFollowed(Integer userId, String order);
    boolean deleteFollower(Integer userId, Integer userIdToUnfollow);
}
