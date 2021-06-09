package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException {
       userRepository.follow(userId, userToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userToUnfollow) throws UserIdNotFoundException {
        userRepository.unfollow(userId, userToUnfollow);
    }

    @Override
    public Integer getFollowersCount(Integer userId) throws UserIdNotFoundException {
        return userRepository.getFollowersCount(userId);
    }

    @Override
    public List<UserDTO> getFollowers(Integer userId, SortingUserEnum sorting) throws UserIdNotFoundException {
        List<User> follows = userRepository.getFollowers(userId);
        List<UserDTO> result = new ArrayList<>();
        for (User u : follows) {
            UserDTO dto = new UserDTO();
            dto.setUserId(u.getUserId());
            dto.setUsername(u.getUsername());
            dto.setFollows(UserMapper.toDTOList(userRepository.getFollows(u.getUserId())));
            result.add(dto);
        }
        return sortByUsernameTest(sorting, result);
    }

    @Override
    public List<UserDTO> getFollows(Integer userId, SortingUserEnum sorting) throws UserIdNotFoundException {
        List<User> follows = userRepository.getFollows(userId);
        List<UserDTO> result = UserMapper.toDTOList(follows);
        for (UserDTO u : result) {
            u.setFollows(UserMapper.toDTOList(userRepository.getFollows(u.getUserId())));
        }
        return sortByUsernameTest(sorting, result);
    }

    private List<UserDTO> sortByUsernameTest(SortingUserEnum sorting, List<UserDTO> result) {
        if (sorting.equals(SortingUserEnum.name_desc)) {
            result.sort(Comparator.comparing(UserDTO::getUsername));
        } else {
            result.sort(Comparator.comparing(UserDTO::getUsername).reversed());
        }
        return result;
    }
}
