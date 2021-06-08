package com.meli.desafio.services;

import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.mappers.UserMapper;
import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.models.dto.ResponseUserListFollowers;
import com.meli.desafio.models.dto.UserDTO;
import com.meli.desafio.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements  IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void addNewFollow(Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        UserDTO userToFollow = UserMapper.userToDTO(userRepository.getById(userIdToFollow));

        User userFollower = userRepository.getById(userId);
        userFollower.getFollowed().add(userToFollow);
    }

    @Override
    public ResponseUserCountFollowers showCountFollowers(Optional<Integer> userId, Optional<String> userName) throws UserNotFoundException {
        User user;
        if(userId.isPresent()){
            user = userRepository.getById(userId.get());
        }
        else{
            user = userRepository.getByName(userName.get());
        }

        ResponseUserCountFollowers response = UserMapper.userToResponse(user);
        response.setFollowersCount(userRepository.getFollowersTo(user).size());

        return response;
    }

    @Override
    public ResponseUserListFollowers showAllFollowers(Integer userId) throws UserNotFoundException {
        User user = userRepository.getById(userId);
        ResponseUserListFollowers userDTO = UserMapper.userToResponseList(user);
        userDTO.setFollowersList(userRepository.getFollowersTo(user));
        return userDTO;
    }

    @Override
    public User showAllFollowed(Integer userId) throws UserNotFoundException {
        return userRepository.getById(userId);
    }
}
