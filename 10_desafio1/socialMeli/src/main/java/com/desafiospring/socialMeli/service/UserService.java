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
        List<User> followersList = userRepository.getFollowersList(userId);
        List<UserDTO> followersListDTO = UserMapper.toDTOList(followersList);

        sortingByName(order, followersListDTO);

        return new UserFollowedDTO(userId, user.getUserName(), followersListDTO);
    }

    @Override
    public UserFollowingDTO getFollowingList(int userId, String order) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        List<User> followingList = userRepository.getFollowedList(userId);
        List<UserDTO> followingListDTO = UserMapper.toDTOList(followingList);

        sortingByName(order, followingListDTO);

        return new UserFollowingDTO(userId, user.getUserName(), followingListDTO);
    }

    @Override
    public void unfollowSeller(int userId, int userIdToFollow)
            throws UserNotFoundException, UserAlreadyUnfollowsException {
        userRepository.findUserById(userId);
        userRepository.findUserById(userIdToFollow);
        userRepository.deleteFollower(userId, userIdToFollow);
    }


    private void sortingByName(String order, List<UserDTO> list) {

        if (order != null && order.equals("name_desc"))
            list.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        if (order != null && order.equals("name_asc"))
            list.sort(Comparator.comparing(UserDTO::getUserName));
    }

}
