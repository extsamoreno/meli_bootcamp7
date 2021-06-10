package com.example.desafio1.service;

import JavaUtils.JavaUtils;
import com.example.desafio1.exception.user.UserAlreadyFollowException;
import com.example.desafio1.exception.user.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.user.UserNotFollowException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.iUserRepository;
import com.example.desafio1.service.dto.user.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowersDTO;
import com.example.desafio1.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService {

    @Autowired
    iUserRepository iUserRepository;

    // Add a user follower
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException {

        // Buyer
        User followerUser = iUserRepository.findUserById(userId);
        // Seller
        User followedUser = iUserRepository.findUserById(userIdToFollow);

        // Exception: Already Follow that user
        for (User follower : followedUser.getFollowers()) {
            if (follower.getUserId() == userId) {
                throw new UserAlreadyFollowException();
            }
        }

        // Exception: The follower is equals the followed
        if (userId.equals(userIdToFollow)) {
            throw new UserFollowEqualsFollowerException();
        }

        // Add List seller followers
        followedUser.getFollowers().add(followerUser);
        // Add List buyer follows
        followerUser.getFollows().add(followedUser);
    }

    // User count followers
    @Override
    public ResponseCountFollowersDTO countFollowers(Integer userId) throws UserNotFoundException {

        User followedUser = iUserRepository.findUserById(userId);
        return UserMapper.toResponseCountFollowersDTO(followedUser, followedUser.getFollowers().size());
    }

    // User list followers
    @Override
    public ResponseListFollowersDTO listFollowers(Integer userId, String order) throws UserNotFoundException {

        User followedUser = iUserRepository.findUserById(userId);

        // Order list by name (asc/desc)
        if (order.equals("name_asc")) {
            JavaUtils.orderByUserNameAsc(followedUser.getFollowers());
        } else if (order.equals("name_desc")) {
            JavaUtils.orderByUserNameDesc(followedUser.getFollowers());
        }
        return UserMapper.toResponseListFollowersDTO(followedUser);
    }

    // User list followed
    @Override
    public ResponseListFollowedDTO listFollowed(Integer userId, String order) throws UserNotFoundException {

        User followerUser = iUserRepository.findUserById(userId);

        // Order users by name (asc/desc)
        if (order.equals("name_asc")) {
            JavaUtils.orderByUserNameAsc(followerUser.getFollows());
        } else if (order.equals("name_desc")) {
            JavaUtils.orderByUserNameDesc(followerUser.getFollows());
        }
        return UserMapper.toResponseListFollowedDTO(followerUser);
    }

    // User unfollows another user
    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, UserNotFollowException {
        iUserRepository.unFollowUser(userId, userIdToUnFollow);
    }
}
