package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.*;
import com.example.desafiospring.socialmeli.model.*;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;
import com.example.desafiospring.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements IUserRepository{
    @Autowired
    IUserRepository userRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        userRepository.addFollowerToUser(userId,userIdToFollow);
    }

    @Override
    public void unFollowUser(int userId, int userIdToUnFollow) throws UserNotFoundException {
        userRepository.removeFollowerToUser(userId,userIdToUnFollow);
    }

    @Override
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        int followersCount = userRepository.getFollowersCount(userId);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                followersCount
        );
    }

    @Override
    public UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<UserFollowDTO> userFollowersDTOS = new ArrayList<>();

        for (User user1: user.getFollowing()
        ) {
            userFollowersDTOS.add(UserMapper.getUserFollowDTO(user1));
        }

        Comparator<UserFollowDTO> userNameComparator = Comparator.comparing(UserFollowDTO::getUserName);

        if(order.isPresent()){
            switch (order.get()){
                case "name_asc": userNameComparator = Comparator.comparing(UserFollowDTO::getUserName);
                    break;
                case "name_desc" : userNameComparator = Comparator.comparing(UserFollowDTO::getUserName).reversed();
                    break;
            }
        } //order asc desc

        userFollowersDTOS.sort(userNameComparator);

        return new UserDTO(
                user.getUsername(),
                user.getUserId(),
                userFollowersDTOS
        );
    }

    @Override
    public UserDTO getUserFollowed(int userId, Optional<String> order) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<UserFollowDTO> userFollowedDTOS = new ArrayList<>();

        for (User user1 : user.getFollowed()
        ) {
            userFollowedDTOS.add(UserMapper.getUserFollowDTO(user1));
        }

        Comparator<UserFollowDTO> userNameComparator = Comparator.comparing(UserFollowDTO::getUserName);
        if (order.isPresent()){
            switch (order.get()) {
                case "name_asc":
                    userNameComparator = Comparator.comparing(UserFollowDTO::getUserName);
                    break;
                case "name_desc":
                    userNameComparator = Comparator.comparing(UserFollowDTO::getUserName).reversed();
                    break;
            }
        }

        userFollowedDTOS.sort(userNameComparator);

        return new UserDTO(
                user.getUsername(),
                user.getUserId(),
                userFollowedDTOS
        );
    }

    @Override
    public void addFollowerToUser(int userId, int userIdToFollow) {

    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        return null;
    }

    @Override
    public int getFollowersCount(int userId) {
        return 0;
    }

    @Override
    public void insertPost(Post post) throws UserNotFoundException {

    }

    @Override
    public void removeFollowerToUser(int userId, int userIdToUnFollow) throws UserNotFoundException {

    }
}