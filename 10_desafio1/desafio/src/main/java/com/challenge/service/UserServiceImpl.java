package com.challenge.service;

import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void follow(Integer userId, Integer userToFollow) throws IOException {
       userRepository.follow(userId, userToFollow);
    }

    @Override
    public Integer getFollowersCount(Integer userId) {
        return userRepository.getFollowersCount(userId);
    }
}
