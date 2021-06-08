package com.desafio1.meli.service;

import com.desafio1.meli.model.User;
import com.desafio1.meli.repository.IUserrepository;
import com.desafio1.meli.service.DTO.RequestFollowUserToUser;
import com.desafio1.meli.service.DTO.ResponseCountFollower;
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
            responseCountFollower.setFollowers_count(user.getFollower().size());
            responseCountFollower.setUserId(user.getId());
            responseCountFollower.setSucessfull(true);
            responseCountFollower.setUserName(user.getName());
        }
        return (responseCountFollower) ;

    }
}
