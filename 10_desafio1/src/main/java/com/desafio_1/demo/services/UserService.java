package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserDTO;
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
import com.desafio_1.demo.services.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDTO addFollowUser(Integer userId, Integer userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed {

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
        User userFollowed = user.getFollowed().stream().filter(u -> u.getId() == userIdToFollow).findFirst().orElse(null);
        if(userFollowed != null){

            return UserMapper.toDTO(user);
        }
        return UserMapper.toDTO(userRepository.addFollowUser(userId, userIdToFollow));
    }

    @Override
    public UserFollowerCountDTO findFollowersCount(Integer userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {

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
    public UserFollowerDTO findFollowersByUserId(Integer userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0){
            throw new UserIdInvalidException();
        }
        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }

        return UserFollowerMapper.toDTO(user);
    }
}
