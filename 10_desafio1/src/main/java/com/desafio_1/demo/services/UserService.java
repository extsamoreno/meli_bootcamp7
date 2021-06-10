package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.constants.OrderConstant;
import com.desafio_1.demo.services.helpers.UserValidatorHelper;
import com.desafio_1.demo.services.mappers.UserFollowerCountMapper;
import com.desafio_1.demo.services.mappers.UserFollowerMapper;
import com.desafio_1.demo.services.mappers.UserFollowedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void addFollowUser(int userId, int userIdToFollow) throws UnhandledException, BadRequestException {

        if(userId == userIdToFollow)
            throw new BadRequestException("El id de seguidor no puede ser el mismo de seguido");

        User user = userRepository.findUserById(userId);
        User userToFollow = userRepository.findUserById(userIdToFollow);

        UserValidatorHelper.validateUserExist(user);
        UserValidatorHelper.validateUserExist(userToFollow);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, createComparatorName(null));
        User userFollowed = followed.stream().filter(u -> u.getId() == userIdToFollow).findFirst().orElse(null);

        if(userFollowed == null)
            userRepository.addFollowUser(userId, userIdToFollow);
    }

    @Override
    public UserFollowerCountDTO findFollowersCount(int userId) throws UnhandledException,BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        return UserFollowerCountMapper.toDTO(user, user.getFollowers().size());
    }

    @Override
    public UserFollowerDTO findFollowersByUserId(int userId, String order) throws UnhandledException, BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        ArrayList<User> followers = userRepository.findFollowersByUserId(userId, createComparatorName(order));

        return UserFollowerMapper.toDTO(user, followers);
    }

    @Override
    public UserFollowedDTO findFollowedByUserId(int userId, String order) throws UnhandledException, BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, createComparatorName(order));

        return UserFollowedMapper.toDTO(user, followed);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) throws UnhandledException, BadRequestException {

        if(userId == userIdToUnfollow)
            throw new BadRequestException("El id de seguidor no puede ser el mismo de seguido");

        User user = userRepository.findUserById(userId);
        User userToUnfollow = userRepository.findUserById(userIdToUnfollow);

        UserValidatorHelper.validateUserExist(user);
        UserValidatorHelper.validateUserExist(userToUnfollow);

        userRepository.unfollowUser(userId, userIdToUnfollow);
    }


    private Comparator<String> createComparatorName(String order){
        Comparator<String> comparator = (a, b) -> a.compareTo(b);

        if(order != null && order.equals(OrderConstant.OrderNameDesc)){
            comparator = (a, b) -> b.compareTo(a);
        }
        return comparator;
    }
}
