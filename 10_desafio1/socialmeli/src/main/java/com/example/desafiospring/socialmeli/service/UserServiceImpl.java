package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;
import com.example.desafiospring.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository IUserRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        IUserRepository.addFollowerToUser(userId, userIdToFollow);
    }

    @Override
    public void unFollowUser(int userId, int userIdToUnFollow) throws UserNotFoundException {
        IUserRepository.removeFollowerToUser(userId,userIdToUnFollow);
    }

    @Override
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        int followersCount = IUserRepository.getFollowersCount(userId);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                followersCount
        );
    }

    @Override
    public UserDTO getUserFollowers(int userId) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        List<UserFollowDTO> userFollowersDTOS = new ArrayList<>();

        for (User user1 : user.getFollowed() //revisar porque sale en rojo
        ) {
            userFollowersDTOS.add(UserMapper.getUserFollowDTO(user1));
        }

        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                userFollowersDTOS
        );
    }

    @Override
    public UserDTO getUserFollowed(int userId) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        List<UserFollowDTO> userFollowedDTOS = new ArrayList<>();

        for (User user1 : user.getFollowers()
        ) {
            userFollowedDTOS.add(UserMapper.getUserFollowDTO(user1));
        }
        return new UserDTO(
                user.getUserName(),
                user.getUserId(),
                userFollowedDTOS
        );
    }

    //0008 - ordenar de manera alfabetica ascendente y descendente.

    @Override
    public UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException {
        User user = IUserRepository.getUserById(userId);
        List<UserFollowDTO> userFollowersDTO = new ArrayList<>();

        for (User user1: user.getFollowers()
        ) {
            userFollowersDTO.add(UserMapper.getUserFollowDTO(user1));
        }

        Comparator<UserFollowDTO> userNameComparator = Comparator.comparing()(UserFollowDTO::getUserName);
        switch (order.get()){
            case "name_asc": userNameComparator = Comparator.comparing(UserFollowDTO::getUserName);
                break;
            case "name_desc" : userNameComparator = Comparator.comparing(UserFollowDTO::getUserName).reversed();
                break;
        }
        //uso del comparator para comparar y ordenar.

        userFollowersDTO.sort(userNameComparator);

        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                userFollowersDTO
        );
    }

    //ordenamiento por fechas ascendente y descendente


}