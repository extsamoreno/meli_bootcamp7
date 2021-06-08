package com.example.demo.services;

import com.example.demo.dtos.UserFollowedListDTO;
import com.example.demo.dtos.UserFollowerListDTO;
import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.repositories.UserRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepositoryImple userRepositoryImple;


    @Override
    public void addUsers() {
        userRepositoryImple.addUsers();
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException {
        if(userRepositoryImple.existUser(userId) && userRepositoryImple.existUser(userIdToFollow)){
            userRepositoryImple.follow(userId,userIdToFollow);
        }

    }

    @Override
    public void unfollow(int userId, int userIdToFollow) {
        if(userRepositoryImple.existUser(userId) && userRepositoryImple.existUser(userIdToFollow)){
            userRepositoryImple.unfollow(userId,userIdToFollow);
        }
    }


    @Override
    public UserFollowersCountDTO followersCount(int userId) {
        UserFollowersCountDTO userFollowersCountDTO = null;
        if(userRepositoryImple.existUser(userId)){
            userFollowersCountDTO =  userRepositoryImple.followersCount(userId);
        }
       return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO getFollowersList(int userId) {
        UserFollowerListDTO userFollowerListDTO = null;
        if(userRepositoryImple.existUser(userId)){
            userFollowerListDTO =  userRepositoryImple.followersList(userId);
        }
        return userFollowerListDTO;
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId) {
        UserFollowedListDTO userFollowedListDTO = null;
        if(userRepositoryImple.existUser(userId)){
            userFollowedListDTO =  userRepositoryImple.followedList(userId);
        }
        return userFollowedListDTO;
    }


}
