package com.meli.socialmeli.services;

import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addNewFollower (int userId, int userIdToFollow) {
        userRepository.addNewFollower(userId, userIdToFollow);
    }
}
