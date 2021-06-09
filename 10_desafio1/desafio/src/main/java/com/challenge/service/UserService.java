package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException;
    Integer getFollowersCount(Integer userId) throws UserIdNotFoundException;
    List<UserDTO> getFollowers(Integer userId) throws UserIdNotFoundException;
    List<UserDTO> getFollows(Integer userId) throws UserIdNotFoundException;
    void unfollow(Integer userId, Integer userToUnfollow) throws UserIdNotFoundException;

}
