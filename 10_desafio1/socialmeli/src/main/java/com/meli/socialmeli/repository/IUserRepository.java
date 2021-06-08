package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    User save(User user);

    User findById(int userId);

    User findByName(String userName);

    List<User> getUserList();

    void followUser(User user, int userIdToFollow);

    void UnfollowUser(int userId, int userIdToFollow);

    int getFollowersAmountByUserId(int userId);

    List<User> getFollowersByUserId(int userId);

    List<Integer> getFollowingByUserId(int userId);

}
