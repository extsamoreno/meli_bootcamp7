package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.UserAmountFollowersDTO;
import com.bootcamp.socialmeli.DTO.UserFollowedListDTO;
import com.bootcamp.socialmeli.DTO.UserFollowersListDTO;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

        User user = userRepository.findById(userId);
        if (user == null) {
            //Throw a exception
        }

        User userToFollow = userRepository.findById(userIdToFollow);
        if (userToFollow == null) {
            //Throw a exception
        }

        //Agrego el usuario a seguir si éste no se encontraba antes
        if (!user.getFollowed().contains(userIdToFollow)) {
            user.getFollowed().add(userIdToFollow);
        }

        //Agrego
        if(!userToFollow.getFollowers().contains(userId)) {
            userToFollow.getFollowers().add(userId);
        }
    }

    @Override
    public UserAmountFollowersDTO getAmountUserFollowers(Integer id) {
        User user = userRepository.findById(id);
        if (user == null) {
            //Throw a exception
        }

        return userMapper.toUserAmountFollowersDTO(user);
    }

    @Override
    public UserFollowersListDTO getListUserFollowers(Integer id) {
        User user = userRepository.findById(id);
        if (user == null) {
            //Throw a exception
        }

        return userMapper.toListUserFollowersDTO(user, userRepository.getUserFollowers(id));
    }

    @Override
    public UserFollowedListDTO getListUserFollowed(Integer id) {
        User user = userRepository.findById(id);
        if (user == null) {
            //Throw a exception
        }

        return userMapper.toListUserFollowedDTO(user, userRepository.getUserFollowed(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
