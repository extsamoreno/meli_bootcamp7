package com.example.demo.services;

import com.example.demo.model.DTO.FollowersListDTO;
import com.example.demo.model.DTO.ResponseCountDTO;
import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.services.mapper.Mapper;
import com.example.demo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserServices{

    @Autowired
    Mapper mapper;

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean followUser(int userId, int userIdToFollow) {
        User followedUser = userRepository.getUserById(userIdToFollow);
        User followingUser = userRepository.getUserById(userId);
        followingUser.getFollowers().add(mapper.toDTO(followedUser));
        followedUser.getFollowed().add(mapper.toDTO(followingUser));
        userRepository.getUserList().add(followedUser);
        userRepository.getUserList().add(followingUser);
        userRepository.getFollowedList().put(userId, followingUser.getFollowers());
        userRepository.getFollowersList().put(userIdToFollow, followedUser.getFollowed());
        return true;
    }

    @Override
    public ResponseCountDTO getFollowersCount(int userId) {
        User user = userRepository.getUserById(userId);
        int followersCount = userRepository.getFollowersList().get(userId).size();
        return mapper.toCountDTO(user.getId(), user.getUserName(), followersCount);
    }

    @Override
    public FollowersListDTO getFollowersList(int userId) {
        User user = userRepository.getUserById(userId);
        List<UserDTO> followers = userRepository.getFollowersList().get(userId);
        return mapper.toFollowersListDTO(user.getUserName(), user.getId(), followers);
    }
}
