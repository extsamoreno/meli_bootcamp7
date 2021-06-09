package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.SocialExceptionMissingParameter;
import com.meli.socialmeli.exception.SocialExceptionUserNotExists;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;
import com.meli.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void createUserFromList(List<UserBaseDTO> userList) {
        userList.forEach(e -> userRepository.save(UserMapper.BaseDTOToModel(e)));
    }

    @Override
    public List<UserBaseDTO> getUserList() {
        return userRepository.getUserList().stream().map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws SocialExceptionUserNotExists {
        userExists(userId);
        userExists(userIdToFollow);
        userRepository.followUser(userId, userIdToFollow);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) throws SocialExceptionUserNotExists {
        userExists(userId);
        userExists(userIdToUnfollow);
        userRepository.UnfollowUser(userId, userIdToUnfollow);
    }

    @Override
    public int getFollowersAmountByUserId(Optional<Integer> userId) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter {
        if (userId.isPresent()) {
            userExists(userId.get());
            return userRepository.getFollowersAmountByUserId(userId.get());
        } else {
            throw new SocialExceptionMissingParameter("userId");
        }
    }

    @Override
    public SellerDTO getFollowersByUserId(Optional<Integer> userId) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter {
        if (userId.isPresent()) {
            userExists(userId.get());
            List<UserBaseDTO> followers = userRepository.getFollowersByUserId(userId.get()).stream().map(this::getUserById).map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
            return UserMapper.modelToSellerDTO(getUserById(userId.get()), followers);
        } else {
            throw new SocialExceptionMissingParameter("userId");
        }
    }

    @Override
    public UserDTO getFollowingByUserId(Optional<Integer> userId) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter {
        if (userId.isPresent()) {
            userExists(userId.get());
            List<UserBaseDTO> following = userRepository.getFollowingByUserId(userId.get()).stream().map(this::getUserById).map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
            return UserMapper.modelToUserDTO(getUserById(userId.get()), following);
        } else {
            throw new SocialExceptionMissingParameter("userId");
        }
    }

    private User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    private User getUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    public void userExists(int userId) throws SocialExceptionUserNotExists {
        User user = getUserById(userId);
        if (user == null) {
            throw new SocialExceptionUserNotExists(userId);
        }
    }

    private void userExists(String userName) throws SocialExceptionUserNotExists {
        User user = getUserByName(userName);
        if (user == null) {
            throw new SocialExceptionUserNotExists(userName);
        }
    }

}
