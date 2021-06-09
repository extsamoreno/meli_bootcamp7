package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.mappers.UserFollowerCountMapper;
import com.desafio_1.demo.services.mappers.UserFollowerMapper;
import com.desafio_1.demo.services.mappers.UserFollowedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserFollowedDTO addFollowUser(int userId, int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException {

        if(userId <= 0){
            throw new UserIdInvalidException();
        }

        if(userIdToFollow <= 0){
            throw new UserIdInvalidException();
        }
        if(userId == userIdToFollow){
            throw new UserIdFollowerEqualsFollowed();
        }

        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }
        ArrayList<User> followed = userRepository.findFollowedByUserId(userId);
        User userFollowed = followed.stream().filter(u -> u.getId() == userIdToFollow).findFirst().orElse(null);
        if(userFollowed != null){

            return UserFollowedMapper.toDTO(user, followed);
        }
        return UserFollowedMapper.toDTO(userRepository.addFollowUser(userId, userIdToFollow), followed);
    }

    @Override
    public UserFollowerCountDTO findFollowersCount(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {

        if(userId <= 0){
            throw new UserIdInvalidException();
        }

        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }
        return UserFollowerCountMapper.toDTO(user, user.getFollowers().size());
    }

    @Override
    public UserFollowerDTO findFollowersByUserId(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0){
            throw new UserIdInvalidException();
        }
        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }

        ArrayList<User> followers = userRepository.findFollowersByUserId(userId);

        return UserFollowerMapper.toDTO(user, followers);
    }

    @Override
    public UserFollowedDTO findFollowedByUserId(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0){
            throw new UserIdInvalidException();
        }
        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId);

        return UserFollowedMapper.toDTO(user, followed);
    }
}
