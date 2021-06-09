package com.meli.spring_challenge.service.user;


import com.meli.spring_challenge.exception.user.UserNotFoundException;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.repository.user.UserRepository;
import com.meli.spring_challenge.service.follow.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowService followService;


    @Override
    public void followUser(int userID, int userIdToFollow) throws UserNotFoundException {
        followService.followUser(userID,userIdToFollow);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }


}
