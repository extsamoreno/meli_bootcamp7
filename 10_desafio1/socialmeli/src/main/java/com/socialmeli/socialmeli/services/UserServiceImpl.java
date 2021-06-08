package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import com.socialmeli.socialmeli.services.dtos.UserFollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        userRepository.addFollowerToUser(userId,userIdToFollow);
    }

    @Override
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        int followersCount = userRepository.getFollowersCount(userId);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                followersCount
        );
    }

    @Override
    public UserDTO getUserFollowers(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<UserFollowDTO> userFollowDTOS = new ArrayList<>();

        for (User user1: user.getFollowers()
             ) {
            userFollowDTOS.add(
                    new UserFollowDTO(
                            user1.getUserId(),
                            user1.getUserName()
                    )
            );
        }

        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                userFollowDTOS
        );
    }



}
