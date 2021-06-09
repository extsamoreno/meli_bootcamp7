package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowersCountUserDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.NoFollowerException;
import com.meli.socialmeli.models.User;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.meli.socialmeli.mapper.UserMapper.mapFollowed;
import static com.meli.socialmeli.mapper.UserMapper.mapFollowers;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addFollower(int userId, int userIdToFollow) throws InvalidIdException, FollowerAlreadyAddedException {

        if (userRepository.userIdIsNotValid(userId) || userRepository.userIdIsNotValid(userIdToFollow)) {
            throw new InvalidIdException();
        }

        if (userRepository.userContainsFollower(userId, userIdToFollow)) {
            throw new FollowerAlreadyAddedException();
        }
        userRepository.insertFollower(userId, userIdToFollow);
    }

    public void removeFollower(int userId, int userIdToUnfollow) throws InvalidIdException, NoFollowerException {

        if (userRepository.userIdIsNotValid(userId) || userRepository.userIdIsNotValid(userIdToUnfollow)) {
            throw new InvalidIdException();
        }

        if (!userRepository.userContainsFollower(userId, userIdToUnfollow)) {
            throw new NoFollowerException();
        }
        userRepository.removeFollower(userId, userIdToUnfollow);
    }

    public FollowersCountUserDTO getFollowersCount(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        int followersCount = userRepository.getNumberOfFollowers(userId);

        FollowersCountUserDTO followersCountUserDTO = new FollowersCountUserDTO();

        followersCountUserDTO.setUserId(userId);
        followersCountUserDTO.setFollowersCount(followersCount);
        followersCountUserDTO.setUserName(userRepository.getUserById(userId).getUserName());

        return followersCountUserDTO;
    }

    public UserDTO getFollowersList(int userId, String order) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());

        userDTO.setFollowers(sortFollows(mapFollowers(user), order));

        return userDTO;
    }

    private List<UserDTO> sortFollows(List<UserDTO> follows, String order) {

        if ("name_desc".equals(order)) {
            return orderFollowersByNameDesc(follows);
        }
        return orderFollowersByNameAsc(follows);
    }

    private List<UserDTO> orderFollowersByNameAsc(List<UserDTO> followers) {

        return followers.stream().sorted(
                Comparator.comparing(UserDTO::getUserName)).collect(Collectors.toList());
    }

    private List<UserDTO> orderFollowersByNameDesc(List<UserDTO> followers) {

        return followers.stream().sorted(
                Comparator.comparing(UserDTO::getUserName).reversed()).collect(Collectors.toList());
    }

    public UserDTO getFollowedList(int userId, String order) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());

        userDTO.setFollowed(sortFollows(mapFollowed(user), order));

        return userDTO;
    }
}
