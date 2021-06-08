package com.challenge.service;

import java.io.IOException;

public interface UserService {

    void follow(Integer userId, Integer userToFollow) throws IOException;
    Integer getFollowersCount(Integer userId);

}
