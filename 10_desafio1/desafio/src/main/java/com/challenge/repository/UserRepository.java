package com.challenge.repository;

import com.challenge.entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserRepository {

    void follow(Integer userId, Integer userToFollow) throws IOException;
    Integer getFollowersCount(Integer userId);
    List<User> getFollowers(Integer userId);
    List<User> getFollows(Integer userId);

}
