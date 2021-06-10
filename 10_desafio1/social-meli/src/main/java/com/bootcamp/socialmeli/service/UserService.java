package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.UserAmountFollowersDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowedListDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowersListDTOres;
import com.bootcamp.socialmeli.exception.FollowYourselfException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IDataRepository dataRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException, FollowYourselfException {

        //Controlo que los id no sean iguales
        if (userId == userIdToFollow) {
            throw new FollowYourselfException();
        }

        User user = dataRepository.findUserById(userId);
        User userToFollow = dataRepository.findUserById(userIdToFollow);

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
    public UserAmountFollowersDTOres getAmountUserFollowers(Integer id) throws UserIdNotFoundException {
        User user = dataRepository.findUserById(id);

        return userMapper.toUserAmountFollowersDTO(user);
    }

    @Override
    public UserFollowersListDTOres getListUserFollowers(Integer id) throws UserIdNotFoundException {
        User user = dataRepository.findUserById(id);

        return userMapper.toListUserFollowersDTO(user, dataRepository.getUserFollowers(id));
    }

    @Override
    public UserFollowedListDTOres getListUserFollowed(Integer id) throws UserIdNotFoundException {
        User user = dataRepository.findUserById(id);

        return userMapper.toListUserFollowedDTO(user, dataRepository.getUserFollowed(id));
    }

    @Override
    public List<User> getAllUsers() {
        return dataRepository.getAllUsers();
    }
}
