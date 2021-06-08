package com.example.desafio1.service;

import com.example.desafio1.exception.UserAlreadyFollowException;
import com.example.desafio1.exception.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.iUserRepository;
import com.example.desafio1.service.dto.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.ResponseListFollowersDTO;
import com.example.desafio1.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceUser implements iServiceUser {

    @Autowired
    iUserRepository iUserRepository;

    // Add a user follower
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException {

        // Buyer
        User followerUser = iUserRepository.findUserById(userId);
        // Seller
        User followedUser = iUserRepository.findUserById(userIdToFollow);

        // Exception: ID doesn't exist
        if (followedUser == null) {
            throw new UserNotFoundException(userIdToFollow);
        }
        if (followerUser == null) {
            throw new UserNotFoundException(userId);
        }

        // Exception: Already Follow that user
        for (User follower : followedUser.getFollowers()) {
            if (follower.getUserId() == userId) {
                throw new UserAlreadyFollowException();
            }
        }

        // Exception: the follower is equals the followed
        if (userId.equals(userIdToFollow)) {
            throw new UserFollowEqualsFollowerException();
        }

        // Add List seller followers
        ArrayList<User> followers = followedUser.getFollowers();
        followers.add(followerUser);
        followedUser.setFollowers(followers);

        // Add List buyer follows
        ArrayList<User> follows = followerUser.getFollows();
        follows.add(followedUser);
        followerUser.setFollows(follows);
    }

    // User count followers
    @Override
    public ResponseCountFollowersDTO countFollowers(Integer userId) throws UserNotFoundException {

        User followedUser = iUserRepository.findUserById(userId);

        // Exception: ID doesn't exist
        if (followedUser == null) {
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toResponseCountFollowersDTO(followedUser, followedUser.getFollowers().size());
    }

    // User list followers
    @Override
    public ResponseListFollowersDTO listFollowers(Integer userId) throws UserNotFoundException {

        User followedUser = iUserRepository.findUserById(userId);

        // Exception: ID doesn't exist
        if (followedUser == null) {
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toResponseListFollowersDTO(followedUser);
    }

    // User list followed
    @Override
    public ResponseListFollowedDTO listFollowed(Integer userId) throws UserNotFoundException {

        User followerUser = iUserRepository.findUserById(userId);

        // Exception: ID doesn't exist
        if (followerUser == null) {
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toResponseListFollowedDTO(followerUser);
    }
}
