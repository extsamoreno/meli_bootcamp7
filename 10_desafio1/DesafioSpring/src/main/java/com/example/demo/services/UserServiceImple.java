package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CantAutofollowException;
import com.example.demo.exceptions.CantUnfollowException;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDontFoundException;
import com.example.demo.repositories.CategoryRepositoryImple;
import com.example.demo.repositories.ProductRepositoryImple;
import com.example.demo.repositories.UserRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepositoryImple userRepositoryImple;
    @Autowired
    ProductRepositoryImple productRepositoryImple;
    @Autowired
    CategoryRepositoryImple categoryRepositoryImple;

    @Override
    public void addUsers() {
        userRepositoryImple.addUsers();
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDontFoundException, CantAutofollowException {
            userRepositoryImple.follow(userId,userIdToFollow);
    }

    @Override
    public void unfollow(int userId, int userIdToFollow) throws UserDontFoundException, CantUnfollowException {
        if(userRepositoryImple.existUser(userId) && userRepositoryImple.existUser(userIdToFollow)){
            userRepositoryImple.unfollow(userId,userIdToFollow);
        }
    }


    @Override
    public UserFollowersCountDTO getFollowersCount(int userId) throws UserDontFoundException {
        UserFollowersCountDTO userFollowersCountDTO =  userRepositoryImple.getFollowersCount(userId);
       return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO getFollowersList(int userId,String order) throws UserDontFoundException {
        UserFollowerListDTO  userFollowerListDTO = userRepositoryImple.getFollowersList(userId, order);
        return userFollowerListDTO;
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId, String order) throws UserDontFoundException {
        UserFollowedListDTO userFollowedListDTO =  userRepositoryImple.getFollowedList(userId,order);
        return userFollowedListDTO;
    }

}
