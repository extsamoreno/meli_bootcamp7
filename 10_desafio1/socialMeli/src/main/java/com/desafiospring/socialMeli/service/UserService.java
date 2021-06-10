package com.desafiospring.socialMeli.service;


import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserAlreadyFollowsException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyUnfollowsException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.User;
import com.desafiospring.socialMeli.repository.IUserRepository;

import com.desafiospring.socialMeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void followSeller(int userId, int userIdToFollow) throws
            UserNotFoundException, UserAlreadyFollowsException {
        userRepository.findUserById(userId);
        userRepository.findUserById(userIdToFollow);
        userRepository.addFollowerToUser(userId, userIdToFollow);
    }

    @Override
    public FollowersCountDTO getNumberOfFollowers(int userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        int count = userRepository.getFollowersCount(userId);
        return new FollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public UserFollowedDTO getFollowers(int userId, String order) throws UserNotFoundException {

        User user = userRepository.findUserById(userId);
        List<UserDTO> followersList = new ArrayList<>();

        for (User u : user.getFollowedBy()) {
            followersList.add(UserMapper.toDto(u));
        }

        if (order != null && order.equals("name_asc"))
            followersList.sort(Comparator.comparing(UserDTO::getUserName));

        if (order != null && order.equals("name_desc"))
            followersList.sort(Comparator.comparing(UserDTO::getUserName).reversed());

        return new UserFollowedDTO(user.getUserId(), user.getUserName(), followersList);
    }

    @Override
    public UserFollowingDTO getFollowingList(int userId, String order) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        List<UserDTO> followingList = new ArrayList<>();

        for (User u : user.getFollowed()) {
            followingList.add(UserMapper.toDto(u));
        }

        if (order != null && order.equals("name_asc"))
            followingList.sort(Comparator.comparing(UserDTO::getUserName));

        if (order != null && order.equals("name_desc"))
            followingList.sort(Comparator.comparing(UserDTO::getUserName).reversed());

        return new UserFollowingDTO(user.getUserId(), user.getUserName(), followingList);
    }

    @Override
    public void unfollowSeller(int userId, int userIdToFollow)
            throws UserNotFoundException, UserAlreadyUnfollowsException {
        userRepository.findUserById(userId);
        userRepository.findUserById(userIdToFollow);
        userRepository.deleteFollower(userId, userIdToFollow);
    }

}
