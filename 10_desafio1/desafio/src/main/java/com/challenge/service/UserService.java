package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void follow(Integer userId, Integer userToFollow) throws IOException;
    Integer getFollowersCount(Integer userId);
    List<UserDTO> getFollowers(Integer userId);
    List<UserDTO> getFollows(Integer userId);

}
