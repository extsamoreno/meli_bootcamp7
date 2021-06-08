package com.meli.socialmeli.service;

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
        User user = getUserById(userId);
        userRepository.followUser(user, userIdToFollow);
    }

    @Override
    public int getFollowersAmountByUserId(Optional<Integer> userId, Optional<String> userName) throws SocialExceptionUserNotExists {
        if(userId.isPresent()){
            userExists(userId.get());
            return userRepository.getFollowersAmountByUserId(userId);
        }
        if (userName.isPresent()){
            userExists(userName.get());
            User user = userRepository.findByName(userName.get());
            return userRepository.getFollowersAmountByUserId(user.getUserId());
        }

    }

    @Override
    public SellerDTO getFollowersByUserId(Optional<Integer> userId, Optional<String> userName) throws SocialExceptionUserNotExists {
        userExists(userId);
        List<UserBaseDTO> followers = userRepository.getFollowersByUserId(userId).stream().map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
        return UserMapper.modelToSellerDTO(getUserById(userId), followers);
    }

    @Override
    public UserDTO getFollowingByUserId(Optional<Integer> userId, Optional<String> userName) {
        return null;
    }

    private User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    private User getUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    private void userExists(int userId) throws SocialExceptionUserNotExists {
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
