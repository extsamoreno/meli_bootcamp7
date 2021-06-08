package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void follow(Integer userId, Integer userToFollow) throws IOException {
       userRepository.follow(userId, userToFollow);
    }

    @Override
    public Integer getFollowersCount(Integer userId) {
        return userRepository.getFollowersCount(userId);
    }

    public List<UserDTO> getFollowers(Integer userId) {
        List<User> follows = userRepository.getFollowers(userId);
        List<UserDTO> result = new ArrayList<>();
        follows.forEach(u -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(u.getUserId());
            dto.setUsername(u.getUsername());
            dto.setFollows(UserMapper.toDTOList(userRepository.getFollows(u.getUserId())));
            result.add(dto);
        });
        return result;
    }
}
