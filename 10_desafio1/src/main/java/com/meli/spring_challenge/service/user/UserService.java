package com.meli.spring_challenge.service.user;

import com.meli.spring_challenge.model.User;

import java.util.List;

public interface UserService {
    void followUser(int userID, int userIdToFollow);
    List<User> getAllUsers();
}
