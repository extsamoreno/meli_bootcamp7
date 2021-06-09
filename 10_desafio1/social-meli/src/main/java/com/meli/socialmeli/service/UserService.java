package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowersCountDTO;
import com.meli.socialmeli.dto.UserFollowedDTO;
import com.meli.socialmeli.dto.UserFollowersDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.model.Follow;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException {
        User userFrom = iUserRepository.findUserById(userId);
        User userTo = iUserRepository.findUserById(userIdToFollow);

        if(userFrom == null) {
            throw new UserIdNotFoundException(userId);
        }

        if(userTo == null) {
            throw new UserIdNotFoundException(userIdToFollow);
        }

        iUserRepository.addFollower(userTo,userFrom);
    }

    @Override
    public FollowersCountDTO getFollowersCount(Integer userId) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new FollowersCountDTO(user.getUserId(), user.getUserName(), iUserRepository.getUserFollowers(userId,null).size());
    }

    @Override
    public UserFollowersDTO getUserFollowers(Integer userId, String order) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new UserFollowersDTO(user.getUserId(), user.getUserName(), iUserRepository.getUserFollowers(userId,order));
    }

    @Override
    public UserFollowedDTO getUserFollowed(Integer userId, String order) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new UserFollowedDTO(user.getUserId(), user.getUserName(), iUserRepository.getUserFollowed(userId,order));
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException {
        if(iUserRepository.findUserById(userId) == null) {
            throw new UserIdNotFoundException(userId);
        }

        if(iUserRepository.findUserById(userIdToUnfollow) == null) {
            throw new UserIdNotFoundException(userIdToUnfollow);
        }

        iUserRepository.deleteFollower(userId,userIdToUnfollow);
    }
}
