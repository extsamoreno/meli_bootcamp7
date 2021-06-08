package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import com.socialmeli.socialmeli.services.dtos.UserFollowDTO;
import com.socialmeli.socialmeli.services.mappers.UserMapper;
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
        List<UserFollowDTO> userFollowersDTOS = new ArrayList<>();

        for (User user1: user.getFollowers()
             ) {
            userFollowersDTOS.add(UserMapper.getUserFollowDTO(user1));
        }

        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                userFollowersDTOS
        );
    }

    @Override
    public UserDTO getUserFollowed(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<UserFollowDTO> userFollowedDTOS = new ArrayList<>();

        for (User user1: user.getFollowed()
        ) {
            userFollowedDTOS.add(UserMapper.getUserFollowDTO(user1));
        }

        return new UserDTO(
                user.getUserName(),
                user.getUserId(),
                userFollowedDTOS
        );
    }



}
