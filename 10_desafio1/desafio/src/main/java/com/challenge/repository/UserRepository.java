package com.challenge.repository;

import com.challenge.entity.User;
import com.challenge.exception.UserIdNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserRepository {

    User getUserById(Integer id);
    void follow(Integer userId, Integer userToFollow) throws IOException ;
    Integer getFollowersCount(Integer userId);
    List<User> getFollowers(Integer userId);
    List<User> getFollows(Integer userId);
    List<Integer> getFollowedIds(Integer userId);
    void unfollow(Integer userId, Integer userToUnfollow);
    boolean checkIfExists(Integer userId);

}
