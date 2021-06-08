package com.example.Challenge.service;

import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.mapper.MapperUser;
import com.example.Challenge.model.User;
import com.example.Challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImpl implements   IUserService{

    @Autowired
    IUserRepository iUserRepository;


    @Override
    public void Follow(Integer userId, Integer userToFollow) {

        User customer =  iUserRepository.getUserById(userId);
        User seller = iUserRepository.getUserById(userToFollow);

        /*List<User> usersFollowed = customer.getFollowed();
        usersFollowed.add(seller);
        customer.setFollowed(usersFollowed);
        */


        List<UserDTO> usersFollowers = seller.getFollowers();
        if (customer!= null){
            usersFollowers.add(MapperUser.toUserDTO(customer));
            seller.setFollowed(usersFollowers);
            iUserRepository.saveChanges(customer);
            iUserRepository.saveChanges(seller);
        }
    }

    @Override
    public UserResponseCountDTO getUserFollowersCount(Integer userId) {
        UserResponseCountDTO userResult = MapperUser.toUserResponseCountDTO(iUserRepository.getUserById(userId));
        return userResult;
    }

    @Override
    public UserResponseListDTO getUserFollowersList(Integer userId) {
        UserResponseListDTO userResult = MapperUser.toUserResponseListDTO(iUserRepository.getUserById(userId));
        return userResult;
    }
}
