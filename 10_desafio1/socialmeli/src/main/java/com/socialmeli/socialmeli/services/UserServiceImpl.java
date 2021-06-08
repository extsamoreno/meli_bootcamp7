package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean followUser(int userId, int userIdToFollow){
        if(
        userRepository.getUserById(userId) == null ||
                userRepository.getUserById(userIdToFollow) == null
        ){
            return false;
        }
        userRepository.addFollowerToUser(userId,userIdToFollow);
        return true;
    }

}
