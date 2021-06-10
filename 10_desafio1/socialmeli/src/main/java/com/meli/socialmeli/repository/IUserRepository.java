package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    User save(User user);

    User findById(int userId);

    User findByName(String userName);

    List<User> getUserList();

    void followUser(int userId, int userIdToFollow);

    void UnfollowUser(int userId, int userIdToFollow);

    int countFollowersByUserId(int userId);

    List<Integer> getFollowersByUserId(int userId);

    List<Integer> getFollowingByUserId(int userId);

    boolean userFollowingUserById(int userId, int userIdFollowing) ;

}
