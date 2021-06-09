package com.desafio1.meli.service;

import com.desafio1.meli.model.*;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserrepository iUserrepository;

    @Override
    public boolean followUser(Integer userId, Integer userIdToFollow){
        RequestFollowUserToUser requestFollowUserToUser = new RequestFollowUserToUser();
        requestFollowUserToUser.setUser(iUserrepository.findUserById(userId));
        requestFollowUserToUser.setUserFollower(iUserrepository.findUserById(userIdToFollow));
        return iUserrepository.follow(requestFollowUserToUser);
    }
    @Override
    public ResponseCountFollower countFollowUser (Integer userId){
        User user = iUserrepository.findUserById(userId);
        ResponseCountFollower responseCountFollower = new ResponseCountFollower();
        if (user != null) {
            responseCountFollower.setFollowers_count(iUserrepository.countFollower(userId));
            responseCountFollower.setUserId(user.getId());
            responseCountFollower.setSucessfull(true);
            responseCountFollower.setUserName(user.getName());
        }
        return (responseCountFollower) ;

    }

    @Override
    public ResponseFollowersListDTO listFollowerUser (Integer userId){
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        if (iUserrepository.findUserById(userId) != null) {
            responseFollowersListDTO = iUserrepository.listFollower(userId);
        }
        return (responseFollowersListDTO) ;
    }

    @Override
    public ResponseFollowsListDTO listFollowUser (Integer userId){
        ResponseFollowsListDTO responseFollowListDTO = new ResponseFollowsListDTO();
        if (iUserrepository.findUserById(userId) != null) {
            responseFollowListDTO = iUserrepository.listFollow(userId);
        }
        return (responseFollowListDTO) ;
    }
}
