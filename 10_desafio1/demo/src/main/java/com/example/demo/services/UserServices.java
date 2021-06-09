package com.example.demo.services;

import com.example.demo.DTO.FollowedListDTO;
import com.example.demo.DTO.FollowersCountDTO;
import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices {

    @Autowired
    IGeneralRepository userRepository;

    public void follow(Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        UserDTO userToFollow = userRepository.findById(userIdToFollow);

        userRepository.follow(user,userToFollow);
    }

    @Override
    public FollowersCountDTO countFollowers(Integer userId) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        FollowersCountDTO followersCount = new FollowersCountDTO(user);
        followersCount.setFollowers_count(userRepository.countFollowers(user));
        return followersCount;
    }

    @Override
    public FollowersListDTO followersList(Integer userId) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        FollowersListDTO followersList = new FollowersListDTO(user);
        followersList.setFollowers(userRepository.followersList(userId));
        return followersList;
    }

    @Override
    public FollowedListDTO followedList(Integer userID) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userID);
        FollowedListDTO followedList = new FollowedListDTO(user);
        followedList.setFollowed(userRepository.followedList(userID));
        return followedList;
    }
}
