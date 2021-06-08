package com.challenge.repository;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserRepository {

    void follow(Integer userId, Integer userToFollow) throws IOException;
    Integer getFollowersCount(Integer userId);

}
