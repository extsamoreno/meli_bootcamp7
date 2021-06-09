package com.meli.desafio.users.services;

import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.mappers.UserMapper;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;
import com.meli.desafio.users.models.dto.UserDTO;
import com.meli.desafio.users.repositories.IUserRepository;
import com.meli.desafio.utils.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements IUserService {

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
    public ResponseUserListFollowers showAllFollowers(Integer userId, String order) throws UserNotFoundException {
        User user = userRepository.getById(userId);
        ResponseUserListFollowers userDTO = UserMapper.userToResponseList(user);
        userDTO.setFollowersList(userRepository.getFollowersTo(user));

        Collections.sort(userDTO.getFollowersList());
        if(order.equalsIgnoreCase("name_desc"))
                Collections.reverse(userDTO.getFollowersList());
        return userDTO;
    }

    @Override
    public User showAllFollowed(Integer userId, String order) throws UserNotFoundException {
        User user = userRepository.getById(userId);

        Collections.sort(user.getFollowed());
        if(order.equalsIgnoreCase("name_desc"))
            Collections.reverse(user.getFollowed());

        return user;
    }

    @Override
    public boolean userExist(Integer userId) {
        return userRepository.userExist(userId);
    }

    @Override
    public User getById(Integer userId) throws UserNotFoundException {
        return userRepository.getById(userId);
    }

    @Override
    public void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException {
        userRepository.removeFollow(userId, userIdToUnfollow);
    }
}
