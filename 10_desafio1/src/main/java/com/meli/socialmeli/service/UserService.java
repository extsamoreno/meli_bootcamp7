package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowersCountUserDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.models.User;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.meli.socialmeli.mapper.UserMapper.mapFollowed;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addFollower(int userId, int userIdToFollow) throws InvalidIdException, FollowerAlreadyAddedException {

        if (userRepository.userIdIsNotValid(userId) || userRepository.userIdIsNotValid(userIdToFollow)) {
            throw new InvalidIdException();
        }

        if (userRepository.userAlreadyContainsFollower(userId, userIdToFollow)) {
            throw new FollowerAlreadyAddedException();
        }
        userRepository.insertFollower(userId, userIdToFollow);

        return "User " + userId + " added successfully to User " + userIdToFollow + " followers";
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

    public UserDTO getFollowersList(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());
        userDTO.setFollowers(mapFollowers(user));

        return userDTO;
    }

    private List<UserDTO> mapFollowers(User user) {

        List<UserDTO> followers = new ArrayList<>();

        for (Map.Entry<Integer, User> entry : user.getFollowers().entrySet()) {

            UserDTO follower = new UserDTO();
            follower.setUserId(entry.getKey());
            follower.setUserName(entry.getValue().getUserName());
            followers.add(follower);
        }
        return followers;
    }

    public UserDTO getFollowedList(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());
        userDTO.setFollowed(mapFollowed(user));

        return userDTO;
    }

}
