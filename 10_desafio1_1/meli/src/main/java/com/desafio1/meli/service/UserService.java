package com.desafio1.meli.service;

import com.desafio1.meli.model.*;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.*;
import com.desafio1.meli.service.orderType.UserOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

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
    public boolean unFollowUser(Integer userId, Integer userIdToFollow){
        RequestUnFollowUserToUser requestUnFollowUserToUser = new RequestUnFollowUserToUser();
        requestUnFollowUserToUser.setUser(iUserrepository.findUserById(userId));
        requestUnFollowUserToUser.setUserUnFollower(iUserrepository.findUserById(userIdToFollow));
        return iUserrepository.unFollow(requestUnFollowUserToUser);
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
    public ResponseFollowersListDTO listFollowerUser (Integer userId, UserOrderType order){
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        if (iUserrepository.findUserById(userId) != null) {
            sortByName(iUserrepository.listFollower(userId).getFollowers(), order);
            responseFollowersListDTO = iUserrepository.listFollower(userId);
        }
        return (responseFollowersListDTO) ;
    }

    @Override
    public ResponseFollowsListDTO listFollowUser (Integer userId,UserOrderType order){
        ResponseFollowsListDTO responseFollowListDTO = new ResponseFollowsListDTO();
        if (iUserrepository.findUserById(userId) != null) {
            sortByName(iUserrepository.listFollow(userId).getFollow(), order);
            responseFollowListDTO = iUserrepository.listFollow(userId);
        }
        return (responseFollowListDTO) ;
    }

    private void sortByName(ArrayList<User> list, UserOrderType order) {
        if (order.equals(UserOrderType.name_desc)) sortByNameDesc(list);
        else if (order.equals(UserOrderType.name_asc)) sortByNameAsc(list);
    }

    private void sortByNameAsc(ArrayList<User> list) {
        list.sort(Comparator.comparing(User::getName));
    }

    private void sortByNameDesc(ArrayList<User> list) {
        list.sort(Comparator.comparing(User::getName).reversed());
    }
}
