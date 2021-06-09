package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.service.IUserService;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;
import com.example.desafiospring.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository IUserRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        IUserRepository.addFollowerToUser(userId, userIdToFollow);
    }

    @Override
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        int followersCount = IUserRepository.getFollowersCount(userId);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                followersCount
        );
    }

    @Override
    public UserDTO getUserFollowers(int userId) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        List<UserFollowDTO> userFollowersDTOS = new ArrayList<>();

        for (User user1 : user.getFollowed() //revisar porque sale en rojo
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
        User user = IUserRepository.getUserById(userId);
        List<UserFollowDTO> userFollowedDTOS = new ArrayList<>();

        for (User user1 : user.getFollowers()
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