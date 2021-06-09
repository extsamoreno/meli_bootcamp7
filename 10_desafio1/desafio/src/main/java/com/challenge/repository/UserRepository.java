package com.challenge.repository;

import com.challenge.entity.User;
import com.challenge.exception.UserIdNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserRepository {

    User getUserById(Integer id);
    void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException;
    Integer getFollowersCount(Integer userId) throws UserIdNotFoundException;
    List<User> getFollowers(Integer userId) throws UserIdNotFoundException;
    List<User> getFollows(Integer userId) throws UserIdNotFoundException;

}
